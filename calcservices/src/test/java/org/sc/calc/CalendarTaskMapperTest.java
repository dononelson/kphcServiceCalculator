package org.sc.calc;

import org.sc.calc.domain.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: honine
 * Date: 2/12/14
 * Time: 11:39 AM
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Arrays;

public class CalendarTaskMapperTest {

    private List<Service> ss = new ArrayList<Service>();

    private Float[] efforts1 = new Float[] { 1.0F,1.0F,1.0F,3.0F,2.0F,2.0F,2.0F,2.0F};
    private Float[] efforts2 = new Float[] { 2.0F,2.0F,2.0F,4.0F,5.0F,5.0F,5.0F,5.0F};

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
        Task t = new Task(TaskState.APPROVED,
                new Date(System.currentTimeMillis()), Region.NCAL, "CRQ42", "descr", 1, "S1", EnvType.PROD);
        System.out.println("converted task: " + CalendarTaskMapper.convertTask(t, ss));
    }

    @Test
    public void testSelectService() throws Exception {
        System.out.println("selected service: " + CalendarTaskMapper.selectService(ss, "S1"));
    }
}
