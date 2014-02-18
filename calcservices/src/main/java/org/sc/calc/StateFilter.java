package org.sc.calc;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/11/14
 * Time: 9:00 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
import java.util.List;

import org.sc.calc.domain.Task;
import org.sc.calc.domain.TaskState;

public class StateFilter implements Filter<Task,TaskState> {
    @Override
    public List<Task> apply(List<Task> tasks, TaskState taskState) {
        List<Task> ts = new ArrayList<Task>();
        for(Task t : tasks) {
            if(t.getState() == taskState) {
                ts.add(t);
            }
        }
        return ts;
    }
}
