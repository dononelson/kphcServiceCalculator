package org.sc.calc;

import org.sc.calc.domain.DateConstraintsInfo;
import org.sc.calc.domain.DatedEffort;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/12/14
 * Time: 10:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class DateConstraintsMapperTest {
    @Test
    public void testApply() throws Exception {
        DateConstraintsMapper dcm = new DateConstraintsMapper();

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

        System.out.println("original: " + des_with_weekend);

        DateConstraintsInfo dci_allow_sunday = new DateConstraintsInfo(
                3,      // pivot idx
                true,  // skip saturdays
                false,  // skip sundays
                false,  // skip holidays
                null);  // no holidays
        List<DatedEffort> result = dcm.apply(des_with_weekend, dci_allow_sunday);
        System.out.println("\n\nno effort on saturday?: " + result);

        DateConstraintsInfo dci_no_weekend = new DateConstraintsInfo(
                3,      // pivot idx
                true,  // skip saturdays
                true,  // skip sundays
                false,  // skip holidays
                null);  // no holidays
        result = dcm.apply(des_with_weekend, dci_no_weekend);
        System.out.println("\n\nno effort in the weekend?: " + result);

        List<Date> holidays = new ArrayList<Date>();
        calendar.set(2014, 2, 12);
        holidays.add(new Date(calendar.getTimeInMillis()));

        DateConstraintsInfo dci_no_weekend_or_holiday = new DateConstraintsInfo(
                3,      // pivot idx
                true,  // skip saturdays
                true,  // skip sundays
                true,  // skip holidays
                holidays);  // no holidays
        result = dcm.apply(des_with_weekend, dci_no_weekend_or_holiday);
        System.out.println("\n\nno effort in the weekend or holidays?: " + result);
    }

}
