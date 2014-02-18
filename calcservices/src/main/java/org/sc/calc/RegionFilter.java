package org.sc.calc;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/11/14
 * Time: 8:56 PM
 * To change this template use File | Settings | File Templates.
 */
import org.sc.calc.domain.Region;
import org.sc.calc.domain.Task;

import java.util.ArrayList;
import java.util.List;

public class RegionFilter implements Filter<Task, Region>{
    @Override
    public List<Task> apply(List<Task> tasks, Region region) {
        List<Task> ts = new ArrayList<Task>();
        for(Task t : tasks) {
            if(t.getRegion() == region) {
                ts.add(t);
            }
        }
        return ts;
    }
}
