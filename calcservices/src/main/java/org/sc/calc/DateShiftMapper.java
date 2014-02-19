package org.sc.calc;

import org.sc.calc.domain.DatedEffort;
import org.sc.calc.domain.DateShiftInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/12/14
 * Time: 5:12 PM
 * To change this template use File | Settings | File Templates.
 *
 * introduce a hole in a sequence of DatedEfforts instances IF the hole is
 * located in between the first and last date of the DatedEfforts' dates, else
 * return the original sequence
 *
 * dates before the 'pivot' have to move earlier IF they are earlier than the hole date
 * dates after the 'pivot' have to move later IF they are later than the hole date
 *
 */
public class DateShiftMapper implements Mapper<DatedEffort, DatedEffort, DateShiftInfo> {
   @Override
    public List<DatedEffort> apply(List<DatedEffort> datedEfforts, DateShiftInfo dsf) {
        Date firstDate = datedEfforts.get(0).date;
        Date lastDate = datedEfforts.get(datedEfforts.size() - 1).date;

        if(firstDate.after(dsf.hole) || lastDate.before(dsf.hole)) {
            // hole not within sequence => return original
            return datedEfforts;
        }
        boolean holeBeforePivot = dsf.hole.before(dsf.pivot);
        List<DatedEffort> des = new ArrayList<DatedEffort>();
        for(DatedEffort de : datedEfforts) {
            if(holeBeforePivot) {
                // might have to move date earlier
                if(!de.date.after(dsf.hole)) {
                    des.add(new DatedEffort(Utils.dateFromOffset(de.date, -1), de.effort));
                }
                else {
                    des.add(de);
                }
            }
            else {
                // might have to move date later
                if(!de.date.before(dsf.hole)) {
                    des.add(new DatedEffort(Utils.dateFromOffset(de.date, 1), de.effort));
                }
                else {
                    des.add(de);
                }
            }
        }
        return des;
    }
}
