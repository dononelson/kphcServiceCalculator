package org.sc.calc.domain;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/12/14
 * Time: 9:02 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.Date;
import java.util.List;

public class DateConstraintsInfo {
    public int pivotIdx;
    public boolean skipSaturdays;
    public boolean skipSundays;
    public boolean skipHolidays;
    public List<Date> holidays;

    public DateConstraintsInfo(int pivotIdx, boolean skipSaturdays, boolean skipSundays, boolean skipHolidays, List<Date> holidays) {
        this.pivotIdx = pivotIdx;
        this.skipSaturdays = skipSaturdays;
        this.skipSundays = skipSundays;
        this.skipHolidays = skipHolidays;
        this.holidays = holidays;
    }
}
