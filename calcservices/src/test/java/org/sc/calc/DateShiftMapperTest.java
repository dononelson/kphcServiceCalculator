package org.sc.calc;

import org.sc.calc.domain.DatedEffort;
import org.sc.calc.domain.DateShiftInfo;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/12/14
 * Time: 5:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class DateShiftMapperTest {
    @Test
    public void testApply() throws Exception {
        Calendar c = Calendar.getInstance();
        Date begin = new Date(c.getTimeInMillis());
        Date end = Utils.dateFromOffset(begin, 6);
        Date pivot = Utils.dateFromOffset(begin, 3);
        List<Date> dates = Utils.dateRange(begin, end);
        List<DatedEffort> des = new ArrayList<DatedEffort>();
        for(Date d : dates) {
            des.add(new DatedEffort(d, 1.0F));
        }

        System.out.println("DatedEfforts BEFORE shift: " + des + "\n\n");

        DateShiftMapper dsf = new DateShiftMapper();

        Date hole = Utils.dateFromOffset(begin, 2);
        DateShiftInfo dsi = new DateShiftInfo(pivot,hole);
        List<DatedEffort> result = dsf.apply(des,dsi);
        System.out.println("DatedEfforts AFTER shift with hole @ " + hole +
                " & pivot @ " + pivot +
                " : " + result + "\n\n");

        hole = Utils.dateFromOffset(begin, 0);
        dsi = new DateShiftInfo(pivot,hole);
        result = dsf.apply(des,dsi);
        System.out.println("DatedEfforts AFTER shift with hole @ " + hole +
                " & pivot @ " + pivot +
                " : " + result + "\n\n");

        hole = Utils.dateFromOffset(begin, 4);
        dsi = new DateShiftInfo(pivot,hole);
        result = dsf.apply(des,dsi);
        System.out.println("DatedEfforts AFTER shift with hole @ " + hole +
                " & pivot @ " + pivot +
                " : " + result + "\n\n");

        hole = Utils.dateFromOffset(begin, 6);
        dsi = new DateShiftInfo(pivot,hole);
        result = dsf.apply(des,dsi);
        System.out.println("DatedEfforts AFTER shift with hole @ " + hole +
                " & pivot @ " + pivot +
                " : " + result + "\n\n");
    }
}
