package org.sc.calc;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/11/14
 * Time: 9:20 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.sc.calc.domain.Task;
import org.sc.calc.domain.CalendarTask;
import org.sc.calc.domain.DatedEffort;
import org.sc.calc.domain.Service;

public class CalendarTaskMapper implements Mapper<Task, CalendarTask, List<Service>> {
   @Override
    public List<CalendarTask> apply(List<Task> ts, List<Service> ss) {
        List<CalendarTask> cts = new ArrayList<CalendarTask>();
        for (Task t : ts) {
            cts.add(convertTask(t, ss));
        }
        return cts;
    }

    // ground a task in an actual calendar; i.e., create
    public static CalendarTask convertTask(Task t, List<Service> ss) {
        Service s = selectService(ss, t.getServiceId());
        List<DatedEffort> des = new ArrayList<DatedEffort>();
        Date startDate = t.getStartDate();
        List<Float> efforts = s.getEfforts();
        for(int i = 0; i < efforts.size(); i++) {
            int offsetFromStartDate = i - Service.PRIOR_LEN;
            des.add(new DatedEffort(Utils.dateFromOffset(startDate, offsetFromStartDate),efforts.get(i)));
        }
        return new CalendarTask(
                t.getState(),
                t.getStartDate(),
                t.getRegion(),
                t.getCRQ(),
                t.getDescription(),
                t.getEnvCount(),
                t.getServiceId(),
                t.getEnvType(),
                des);
    }

    public static Service selectService(Iterable<Service> ss, String serviceId) {
        Service result = null;
        for(Service s : ss) {
            if( s.getId() == serviceId) {
                result = s;
                break;
            }
        }
        return result;
    }
}
