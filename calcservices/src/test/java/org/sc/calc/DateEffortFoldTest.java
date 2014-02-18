package org.sc.calc;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.sc.calc.domain.DatedEffort;
import org.sc.calc.domain.CalendarTask;
import org.sc.calc.domain.EnvType;
import org.sc.calc.domain.TaskState;
import org.sc.calc.domain.Region;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/12/14
 * Time: 2:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class DateEffortFoldTest {

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @Test
    public void testApply() throws Exception {
        List<CalendarTask> cts = new ArrayList<CalendarTask>();

        Calendar c = Calendar.getInstance();
        Date now = new Date(c.getTimeInMillis());

        Date begin1 = Utils.dateFromOffset(now, 1);
        Date end1 = Utils.dateFromOffset(now, 15);
        Date start1 = Utils.dateFromOffset(now, 5);
        CalendarTask ct1 = createCalendarTask(begin1, end1, start1, 1);
        cts.add(ct1);

        Date begin2 = Utils.dateFromOffset(now, 12);
        Date end2 = Utils.dateFromOffset(now, 27);
        Date start2 = Utils.dateFromOffset(now, 17);
        CalendarTask ct2 = createCalendarTask(begin2, end2, start2, 2);
        cts.add(ct2);

        Date begin3 = Utils.dateFromOffset(now, 3);
        Date end3 = Utils.dateFromOffset(now, 18);
        Date start3 = Utils.dateFromOffset(now, 8);
        CalendarTask ct3 = createCalendarTask(begin3, end3, start3, 3);
        cts.add(ct3);

        DateEffortFold def = new DateEffortFold();

        Date testDate1 = Utils.dateFromOffset(now, 2);
        assertEquals((double)def.apply(cts,testDate1),1.0);

        Date testDate2 = Utils.dateFromOffset(now, 14);
        assertEquals((double)def.apply(cts,testDate2),6.0);

        Date testDate3 = Utils.dateFromOffset(now, 20);
        assertEquals((double)def.apply(cts,testDate3),2.0);
    }

    @Test
    public void testSelectOnDate() throws Exception {
        Calendar c = Calendar.getInstance();
        Date now = new Date(c.getTimeInMillis());
        Date then = Utils.dateFromOffset(now, 15);
        Date start = Utils.dateFromOffset(now, 5);
        Date targetDate = Utils.dateFromOffset(now, 10);
        CalendarTask ct = createCalendarTask(now, then, start, 1);
        System.out.println(
                "CalendarTask: " + ct + "\n" +
                "DateEffort found: " + DateEffortFold.selectOnDate(ct, targetDate));

    }

     private CalendarTask createCalendarTask(Date begin, Date end, Date start, float effort) {
         List<Date> dates = Utils.dateRange(begin, end);
         List<DatedEffort> des = new ArrayList<DatedEffort>();
         for(Date d : dates) {
             des.add(new DatedEffort(d, effort));
         }
         CalendarTask ct = new CalendarTask(
                 TaskState.APPROVED,
                 start,
                 Region.NCAL,
                 "CRQ42",
                 "descr",
                 1,
                 "S1",
                 EnvType.PROD,
                 des);
            return ct;
     }
}
