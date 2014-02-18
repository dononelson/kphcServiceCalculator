package org.sc.calc;

import org.sc.calc.domain.DatedEffort;
import org.sc.calc.domain.DateConstraintsInfo;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/13/14
 * Time: 7:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class DateConstraintsValidationFoldTest {
    @Test
    public void testApply() throws Exception {
        DateConstraintsValidationFold dcvf = new DateConstraintsValidationFold();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 2, 7);
        Date begin = new Date(calendar.getTimeInMillis());
        calendar.set(2014, 2, 13);
        // note: this date range contains 1 weekend: 2014/2/8 - 2014/2/9
        Date end = new Date(calendar.getTimeInMillis());

        List<Date> dates = Utils.dateRange(begin, end);
        List<DatedEffort> des_with_weekend = new ArrayList<DatedEffort>();
        for(Date d : dates) {
            des_with_weekend.add(new DatedEffort(d, 1.0F));
        }

        DateConstraintsInfo dci_allow_weekend = new DateConstraintsInfo(
                3,      // pivot idx
                false,  // skip saturdays
                false,  // skip sundays
                false,  // skip holidays
                null);  // no holidays

        assertEquals((boolean)dcvf.apply(des_with_weekend,dci_allow_weekend), true);

        DateConstraintsInfo dci_do_not_allow_weekend = new DateConstraintsInfo(
                3,      // pivot idx
                true,  // skip saturdays
                true,  // skip sundays
                false,  // skip holidays
                null);  // no holidays

        assertEquals((boolean)dcvf.apply(des_with_weekend,dci_allow_weekend), true);
    }
}
