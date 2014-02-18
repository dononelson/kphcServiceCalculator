package org.sc.calc;

import org.sc.calc.domain.DateConstraintsInfo;
import org.sc.calc.domain.DatedEffort;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/13/14
 * Time: 7:51 AM
 * To change this template use File | Settings | File Templates.
 *
 * strategy:
 * the correctness of a DatedEffort sequence is predicated on
 * enforcement of the constraints as contained in the 'date constraints info
 * =>
 * iterated through the sequence to verify the constraints hold for all elements
 */
public class DateConstraintsValidationFold implements Fold<DatedEffort,Boolean,DateConstraintsInfo> {
    @Override
    // return tru if constraints hold for all elements
    public Boolean apply(List<DatedEffort> datedEfforts, DateConstraintsInfo dci) {
        Boolean result = true;
        for( DatedEffort datedEffort : datedEfforts) {
            if(Utils.needShift(datedEffort.date, dci)) {
                result = false; // constraint violation
                break;
            }
        }
        return result;
    }
}
