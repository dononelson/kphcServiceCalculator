package org.sc.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.sc.calc.domain.CalendarTask;
import org.sc.calc.domain.EnvType;
import org.sc.calc.domain.Region;
import org.sc.calc.domain.Service;
import org.sc.calc.domain.Task;
import org.sc.calc.domain.TaskState;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA. User: honine Date: 2/12/14 Time: 11:39 AM To change this template use File | Settings | File Templates.
 */
public class CalendarTaskMapperTest {

    private final List<Service> ss = new ArrayList<Service>();

    private final Float[] efforts1 = new Float[] { 1.0F, 1.0F, 1.0F, 3.0F, 2.0F, 2.0F, 2.0F, 2.0F };
    private final Float[] efforts2 = new Float[] { 2.0F, 2.0F, 2.0F, 4.0F, 5.0F, 5.0F, 5.0F, 5.0F };

    @BeforeMethod
    public void setUp() throws Exception {
        ss.add(new Service("S1", "descr", new ArrayList<Float>(Arrays.asList(efforts1))));
        ss.add(new Service("S2", "descr", new ArrayList<Float>(Arrays.asList(efforts2))));
        ss.add(new Service("S3", "descr", new ArrayList<Float>(Arrays.asList(efforts2))));
    }

    @Test
    public void testApply() throws Exception {

    }

    @Test
    public void testConvertTask() throws Exception {
        final Task t = new Task(TaskState.APPROVED, new Date(System.currentTimeMillis()), Region.NCAL, "CRQ42", "descr", 1, "S1", EnvType.PROD);
        System.out.println("converted task: " + CalendarTaskMapper.convertTask(t, ss));
    }

    @Test
    public void testSelectService() throws Exception {
        System.out.println("selected service: " + CalendarTaskMapper.selectService(ss, "S1"));
    }

    @Test
    public void testNumberOfInstances() {
        final Task t = new Task(TaskState.APPROVED, new Date(System.currentTimeMillis()), Region.NCAL, "CRQ42", "descr", 2, "S1", EnvType.PROD);
        final CalendarTask calendarTask = CalendarTaskMapper.convertTask(t, ss);
        System.out.println("converted task: " + calendarTask);
    }
}
