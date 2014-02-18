package org.sc.calc;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/11/14
 * Time: 9:46 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;

import org.sc.calc.domain.DatedEffort;
import org.sc.calc.domain.CalendarTask;
import org.sc.calc.domain.Task;
import org.sc.calc.domain.Region;
import org.sc.calc.domain.Resources;
import org.sc.calc.domain.Service;
import org.sc.calc.domain.TaskState;

public class Engine {
    public static Map<String,List<DatedEffort>> calcEffort(
            List<Task> tasks,
            List<Service> services,
            List<Region> regions,
            Date startDate,
            Date endDate,
            Resources resources) {
        Map<String,List<DatedEffort>> result = new HashMap<String, List<DatedEffort>>();
        List<List<DatedEffort>> des = new ArrayList<List<DatedEffort>>();
        for(Region region : regions) {
            List<DatedEffort> de = calcEffort(tasks, services, region, startDate, endDate);
            result.put(region.name(), de);
            des.add(de);
        }

        // build list of efforts for all dates in ‘dateRange’
        List<Date> dateRange = Utils.dateRange(startDate, endDate);
        RegionDateEffortFold rdef = new RegionDateEffortFold();
        List<Float> efforts = new ArrayList<Float>();
        for( Date d : dateRange) {
            efforts.add(rdef.apply(des, d));
        }
        DateEffortZip dez = new DateEffortZip();
        List<DatedEffort> totals = dez.apply(dateRange,efforts);
        result.put("total", totals);

        Double capacity = resources.getStaffCount() * resources.getHoursPerStaff();
        // destructive update of totals
        for(DatedEffort de: totals) {
            de.effort = de.effort - capacity.intValue();
        }
        result.put("avail", totals);
        return result;
    }

    public static List<DatedEffort> calcEffort(
            List<Task> tasks,
            List<Service> services,
            Region region,
            Date startDate,
            Date endDate) {

        StateFilter sf = new StateFilter();
        RegionFilter rf = new RegionFilter();
        CalendarTaskMapper ctm = new CalendarTaskMapper();
        DateRangeFilter drf = new DateRangeFilter();
        List<Date> dateRange = Utils.dateRange(startDate, endDate);
        DateEffortFold def = new DateEffortFold();
        DateEffortZip dez = new DateEffortZip();

        List<Task> filteredTasks = rf.apply(sf.apply(tasks, TaskState.APPROVED), region);
        List<CalendarTask> calendarTasks = ctm.apply(filteredTasks,services);

        List<CalendarTask> inRangeCalendaredTasks = drf.apply(calendarTasks, dateRange);

        // build list of efforts for all dates in ‘dateRange’
        List<Float> efforts = new ArrayList<Float>();
        for( Date d : dateRange) {
            efforts.add(def.apply(inRangeCalendaredTasks, d));
        }

        // zip efforts and date range together…
        List<DatedEffort> datedEfforts = dez.apply(dateRange, efforts);

        return datedEfforts;
    }

    // evaluate with an additional prospective task
    public static List<DatedEffort> calcEffort(
            List<Task> tasks,
            List<Service> services,
            Region region,
            Date startDate,
            Date endDate,
            Task prospectiveTask) {

        prospectiveTask.setState(TaskState.APPROVED);
        tasks.add(prospectiveTask);
        return calcEffort(tasks,services,region,startDate,endDate);
    }

}
