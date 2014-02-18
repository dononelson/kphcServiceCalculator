package org.sc.calc;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/13/14
 * Time: 12:08 PM
 * To change this template use File | Settings | File Templates.
 */
import org.sc.calc.domain.CalendarTask;
import org.sc.calc.domain.DatedEffort;
import java.util.Date;
import java.util.List;

public class RegionDateEffortFold implements Fold<List<DatedEffort>, Float, Date> {
    @Override
    public Float apply(List<List<DatedEffort>> dess, Date d) {
        float result = 0;
        for(List<DatedEffort> des : dess) {
            DatedEffort de = selectOnDate(des, d);
            result += de.effort;
        }
        return result;
    }

    public static DatedEffort selectOnDate(List<DatedEffort> des, Date d) {
        DatedEffort result = new DatedEffort(d, 0.0F);
        for(DatedEffort de : des) {
            if(de.date.equals(d)) {
                result = de;
            }
        }
        return result;
    }
}
