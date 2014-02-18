package org.sc.calc;


/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/11/14
 * Time: 9:58 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.sql.Date;


import org.sc.calc.domain.EnvType;
import org.sc.calc.domain.Region;
import org.sc.calc.domain.Task;
import org.sc.calc.domain.TaskState;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegionFilterTest {
    private List<Task> ts = new ArrayList<Task>();

    @BeforeMethod
    public void setUp() throws Exception {
        Calendar c = Calendar.getInstance();
        c.set(2014, 1, 15);
        ts.add(new Task(TaskState.APPROVED, new Date(c.getTimeInMillis()), Region.NCAL, "CRQ1", "descr", 1, "456", EnvType.PROD));
        c.set(2014, 2, 16);
        ts.add(new Task(TaskState.APPROVED, new Date(c.getTimeInMillis()), Region.MAS, "CRQ1", "descr", 1, "456", EnvType.NP));
        c.set(2014, 3, 17);
        ts.add(new Task(TaskState.APPROVED, new Date(c.getTimeInMillis()), Region.NCAL, "CRQ1", "descr", 1, "456", EnvType.NP));
    }

    @Test
    public void testApply() throws Exception {
        RegionFilter rf = new RegionFilter();
        List<Task> filteredTasks = rf.apply(ts,Region.NCAL);
        assertEquals(filteredTasks.size() , 2);
    }
}
