package org.sc.calc;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/11/14
 * Time: 5:00 PM
 * To change this template use File | Settings | File Templates.
 */
import org.sc.calc.domain.CalendarTask;

import java.util.Date;
import java.util.List;

public class DateFilter implements Filter<CalendarTask,Date> {
    public List<CalendarTask> apply(List<CalendarTask> cts, Date d) {
        // create new Task iterable (e.g., List<Task>)
        // add only those tasks in ‘cts’ that have date ‘d’ in their range
        return null;
    }
}
