package org.sc.calc;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/11/14
 * Time: 5:09 PM
 * To change this template use File | Settings | File Templates.
 */
import org.sc.calc.domain.CalendarTask;

import java.util.Date;
import java.util.List;

public class DateRangeFilter implements Filter<CalendarTask,Iterable<Date>> {
    public List<CalendarTask> apply(List<CalendarTask> cts, Iterable<Date> ds) {
        // create new CalendarTask iterable (e.g., List<CalendarTask>)
        // add only those tasks in ‘cts’ that have any date in ‘ds’ in their range
        return null;
    }
}
