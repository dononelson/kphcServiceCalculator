package org.sc.calc;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/11/14
 * Time: 11:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class UtilsTest {
    @Test
    public void testDateRange() throws Exception {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        Date now = new Date(c.getTimeInMillis());
        c.add(Calendar.DATE, 10);
        Date then = new Date(c.getTimeInMillis());
        List<Date> dates = Utils.dateRange(now, then);
        for( Date d : dates) {
            System.out.println("Date: " + d.toString());
        }
    }

    @Test
    public void testDateArith() throws Exception {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        Date now = new Date(c.getTimeInMillis());
        c.add(Calendar.DATE, -1);
        Date then = new Date(c.getTimeInMillis());
        System.out.println("Date now: " + now.toString());
        System.out.println("Date then: " + then.toString());
    }

    @Test
    public void testDateFromOffset() throws Exception {
        Calendar c = Calendar.getInstance();
        Date now = new Date(c.getTimeInMillis());
        Date then = Utils.dateFromOffset(now, -45);
        System.out.println("Date now: " + now.toString());
        System.out.println("Date then: " + then.toString());
    }

    @Test
    public void testIsSaturday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 2, 8);
        Date date = new Date(calendar.getTimeInMillis());
        System.out.println("A saturday?: " + date);
        assertEquals(Utils.isSaturday(date), true);
    }

    @Test
    public void testIsSunday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 2, 9);
        Date date = new Date(calendar.getTimeInMillis());
        System.out.println("A sunday?: " + date);
        assertEquals(Utils.isSunday(date), true);
    }

    @Test
    public void testIsHoliday() {
        Calendar calendar = Calendar.getInstance();
        List<Date> holidays = new ArrayList<Date>();
        calendar.set(2014, 1, 1);
        holidays.add(new Date(calendar.getTimeInMillis()));
        calendar.set(2014, 2, 2);
        holidays.add(new Date(calendar.getTimeInMillis()));
        calendar.set(2014, 3, 3);
        holidays.add(new Date(calendar.getTimeInMillis()));

        calendar.set(2014, 4, 5);
        Date date = new Date(calendar.getTimeInMillis());
        assertEquals(Utils.isHoliday(date, holidays), false);

        calendar.set(2014, 2, 2, 11, 59, 00);
        date = new Date(calendar.getTimeInMillis());
        assertEquals(Utils.isHoliday(date, holidays), true);
    }
}
