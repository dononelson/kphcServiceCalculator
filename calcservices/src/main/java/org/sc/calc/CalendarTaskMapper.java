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

import org.sc.calc.domain.CalendarTask;
import org.sc.calc.domain.DatedEffort;
import org.sc.calc.domain.Service;
import org.sc.calc.domain.Task;

public class CalendarTaskMapper implements Mapper<Task, CalendarTask, List<Service>> {
    @Override
    public List<CalendarTask> apply(final List<Task> ts, final List<Service> ss) {
        final List<CalendarTask> cts = new ArrayList<CalendarTask>();
        for (final Task t : ts) {
            cts.add(convertTask(t, ss));
        }
        return cts;
    }

    // ground a task in an actual calendar; i.e., create
    public static CalendarTask convertTask(final Task t, final List<Service> ss) {
        final Integer envCount = t.getEnvCount();
        if (envCount <= 0) {
            throw new IllegalArgumentException("The environment count must be greater than zero");
        }

        final Service s = selectService(ss, t.getServiceId());
        final List<DatedEffort> des = new ArrayList<DatedEffort>();
        final Date startDate = t.getStartDate();
        final List<Float> efforts = s.getEfforts();

        for (int i = 0; i < efforts.size(); i++) {
            final int offsetFromStartDate = i - Service.PRIOR_LEN;
            final float totalEffort = efforts.get(i) * envCount;
            des.add(new DatedEffort(Utils.dateFromOffset(startDate, offsetFromStartDate), totalEffort));
        }
        return new CalendarTask(t.getState(), t.getStartDate(), t.getRegion(), t.getCRQ(), t.getDescription(), t.getEnvCount(), t.getServiceId(),
                t.getEnvType(), des);
    }

    public static Service selectService(final Iterable<Service> ss, final String serviceId) {
        Service result = null;
        for (final Service s : ss) {
            if (s.getId() == serviceId) {
                result = s;
                break;
            }
        }
        return result;
    }
}
