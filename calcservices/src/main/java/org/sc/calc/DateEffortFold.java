package org.sc.calc;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/11/14
 * Time: 10:42 PM
 * To change this template use File | Settings | File Templates.
 */
import org.sc.calc.domain.CalendarTask;
import org.sc.calc.domain.DatedEffort;
import java.util.Date;
import java.util.List;

public class DateEffortFold implements Fold<CalendarTask, Float, Date> {
    @Override
    public Float apply(List<CalendarTask> cts, Date d) {
        float result = 0;
        for(CalendarTask ct : cts) {
            DatedEffort de = selectOnDate(ct, d);
            result += de.effort;
        }
        return result;
    }

    public static DatedEffort selectOnDate(CalendarTask ct, Date d) {
        DatedEffort result = new DatedEffort(d, 0.0F);
        for(DatedEffort de : ct.getDatedEfforts()) {
            if(de.date.equals(d)) {
                result = de;
            }
        }
        return result;
    }
}
