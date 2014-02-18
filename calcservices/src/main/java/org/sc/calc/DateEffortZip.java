package org.sc.calc;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/11/14
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
import org.sc.calc.domain.DatedEffort;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class DateEffortZip implements Zip<Date,Float,DatedEffort> {
    public List<DatedEffort> apply(List<Date> ds, List<Float> es) {
        List<DatedEffort> des = new ArrayList<DatedEffort>();
        while(ds.iterator().hasNext() && es.iterator().hasNext()) {
            des.add(new DatedEffort(ds.iterator().next(),es.iterator().next()));
        }
        return des;
    }
}