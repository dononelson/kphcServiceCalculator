package org.sc.calc;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/11/14
 * Time: 9:46 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sc.calc.domain.CalendarTask;
import org.sc.calc.domain.DatedEffort;
import org.sc.calc.domain.Region;
import org.sc.calc.domain.Resources;
import org.sc.calc.domain.Service;
import org.sc.calc.domain.Task;
import org.sc.calc.domain.TaskState;

public class Engine {
    public static Map<String, List<DatedEffort>> calcEffort(final List<Task> tasks, final List<Service> services, final List<Region> regions,
            final Date startDate, final Date endDate, final Resources resources) {
        final Map<String, List<DatedEffort>> result = new HashMap<String, List<DatedEffort>>();
        final List<List<DatedEffort>> des = new ArrayList<List<DatedEffort>>();
        for (final Region region : regions) {
            final List<DatedEffort> de = calcEffort(tasks, services, region, startDate, endDate);
            result.put(region.name(), de);
            des.add(de);
        }

        // build list of efforts for all dates in dateRange
        final List<Date> dateRange = Utils.dateRange(startDate, endDate);
        final RegionDateEffortFold rdef = new RegionDateEffortFold();
        final List<Float> efforts = new ArrayList<Float>();
        for (final Date d : dateRange) {
            efforts.add(rdef.apply(des, d));
        }
        final DateEffortZip dez = new DateEffortZip();
        final List<DatedEffort> totals = dez.apply(dateRange, efforts);
        result.put("total", totals);

        final Double capacity = resources.getStaffCount() * resources.getHoursPerStaff();
        // destructive update of totals
        for (final DatedEffort de : totals) {
            de.effort = de.effort - capacity.intValue();
        }
        result.put("avail", totals);
        return result;
    }

    public static List<DatedEffort> calcEffort(final List<Task> tasks, final List<Service> services, final Region region, final Date startDate,
            final Date endDate) {

        final StateFilter sf = new StateFilter();
        final RegionFilter rf = new RegionFilter();
        final CalendarTaskMapper ctm = new CalendarTaskMapper();
        final DateRangeFilter drf = new DateRangeFilter();
        final List<Date> dateRange = Utils.dateRange(startDate, endDate);
        final DateEffortFold def = new DateEffortFold();
        final DateEffortZip dez = new DateEffortZip();

        final List<Task> filteredTasks = rf.apply(sf.apply(tasks, TaskState.APPROVED), region);
        final List<CalendarTask> calendarTasks = ctm.apply(filteredTasks, services);

        final List<CalendarTask> inRangeCalendaredTasks = drf.apply(calendarTasks, dateRange);

        // build list of efforts for all dates in ���dateRange���
        final List<Float> efforts = new ArrayList<Float>();
        for (final Date d : dateRange) {
            efforts.add(def.apply(inRangeCalendaredTasks, d));
        }

        // zip efforts and date range together���
        final List<DatedEffort> datedEfforts = dez.apply(dateRange, efforts);

        return datedEfforts;
    }

    // evaluate with an additional prospective task
    public static List<DatedEffort> calcEffort(final List<Task> tasks, final List<Service> services, final Region region, final Date startDate,
            final Date endDate, final Task prospectiveTask) {

        prospectiveTask.setState(TaskState.APPROVED);
        tasks.add(prospectiveTask);
        return calcEffort(tasks, services, region, startDate, endDate);
    }

}
