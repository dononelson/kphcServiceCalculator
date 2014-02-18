package org.sc.calc;

import org.sc.calc.domain.DateConstraintsInfo;
import org.sc.calc.domain.DatedEffort;
import org.sc.calc.domain.DateShiftInfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/12/14
 * Time: 9:00 PM
 * To change this template use File | Settings | File Templates.
 *
 * strategy: introduce 'holes' in a dated effort range based on the occurrence of
 * weekend days and holidays - if needed
 */
public class DateConstraintsMapper implements Mapper<DatedEffort, DatedEffort, DateConstraintsInfo> {
    @Override
    /*
        approach:
        as the pivot entry is 'set in stone' (NOT to move to another day), we work outwards
        from the pivot: towards the start of the list & towards the end of the list
        this avoids extra 'holes'
        ANY time a hole is introduced at a location in the list, we revisit the same
        location again, as the entry at that location might have to make room for a hole
        multiple times; e.g., to skip past a weekend or another multi-day consecutive
        set of holes
     */
    public List<DatedEffort> apply(List<DatedEffort> datedEfforts, DateConstraintsInfo dci) {
        List<DatedEffort> result = datedEfforts;
        // construct a (ordered) list of date effort list indices to visit:
        // outwards from the pivot: towards the start of the list & towards the end of the list
        List<Integer> idxVisitOrder = new ArrayList<Integer>();
        for(int idx = dci.pivotIdx - 1; idx >= 0; idx--) idxVisitOrder.add(idx);
        for(int idx = dci.pivotIdx + 1; idx < datedEfforts.size(); idx++) idxVisitOrder.add(idx);
        // note: pivot is at constant position
        Date pivot = datedEfforts.get(dci.pivotIdx).date;

        // get a date shift filter to do the actual work
        DateShiftMapper dateShiftMap = new DateShiftMapper();
        for(int i = 0; i < idxVisitOrder.size(); ) {
            int deIdx = idxVisitOrder.get(i);
            Date date = result.get(deIdx).date;
            if(Utils.needShift(date, dci)) {
                // need a hole right where the idx is at (i.e., hole = date)...
                DateShiftInfo dateShiftInfo = new DateShiftInfo(pivot, date);
                result = dateShiftMap.apply(result, dateShiftInfo);
                // about to visit the same DateEfforts entry again...
            }
            else {
                i++; // prep to visit next DateEfforts entry...
            }
        }
        return result;
    }
}
