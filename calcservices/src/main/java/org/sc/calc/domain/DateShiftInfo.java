package org.sc.calc.domain;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/12/14
 * Time: 5:13 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.Date;

// to be used to introduce a "hole" in a sequence of dates (or entities that contain date values)
public class DateShiftInfo {

    public Date pivot;
    public Date hole;

    public DateShiftInfo(Date pivot, Date hole) {
        this.pivot = pivot;
        this.hole = hole;
    }
}
