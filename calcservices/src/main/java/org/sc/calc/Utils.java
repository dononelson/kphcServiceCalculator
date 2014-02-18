package org.sc.calc;

import org.apache.commons.lang.time.DateUtils;
import org.sc.calc.domain.DateConstraintsInfo;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/11/14
 * Time: 11:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Utils {
    // add dates from 'from' up to and including 'to' to date range
    public static List<Date> dateRange(Date from, Date to) {
        List<Date> dates = new ArrayList<Date>();
        Calendar c = Calendar.getInstance();
        c.setTime(from);
        Date d = from;
        do {
            dates.add(d);
            c.add(Calendar.DATE, 1);
            d = new Date(c.getTimeInMillis());
        }
        while(d.before(to));
        dates.add(to);

        return dates;
    }

    public static Date dateFromOffset(Date d, int offset) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DATE, offset);
        return new Date(c.getTimeInMillis());

    }
    public static boolean needShift(Date d, DateConstraintsInfo dci) {
        return (dci.skipSaturdays && isSaturday(d)) ||
                (dci.skipSundays && isSunday(d)) ||
                (dci.skipHolidays && isHoliday(d, dci.holidays));
    }

    public static boolean isSaturday(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY;
    }

    public static boolean isSunday(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
    }

    public static boolean isHoliday(Date d, List<Date> holidays) {
        boolean result = false;
        if(holidays != null) {
            for(Date h : holidays) {
                // compare dates based on 'day' value only; i.e., ignore time of day
                if(DateUtils.isSameDay(h, d)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
