package org.sc.crud.repo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.sc.crud.model.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;

@ContextConfiguration("classpath:/test-app-context.xml")
public class ServiceRepoTest extends AbstractTransactionalTestNGSpringContextTests {
    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceRepoTest.class);

    /** The dao. */
    @Autowired
    private ServiceRepo dao;

    // test saving a Service to the database
    // @Test
    public void testSave() {
        final Service newService = new Service();
        newService.setDaysArray("1,1,6,12,12,12,12,12,2");
        newService.setDescription("S6 : Environment Refresh Non-Prod from Prod Full Copy");
        newService.setEffort("medium");
        newService.setLead_Time(new Float(5.0));
        newService.setLead_Time_Unit("days");
        newService.setMax_Hours(new Float(70.0));
        final short startPriorDays = 3;
        newService.setStart_Prior_days(startPriorDays);
        newService.setType("S6");
        newService.setEffective_date(new Date());
        dao.saveAndFlush(newService);
    }

    // test to find a Service by its Id
    // @Test
    public void testFindById() {
        LOGGER.info("Starting testFindById test");
        final long serviceId = 1;
        final Service d = dao.findById(serviceId);
        LOGGER.info("DatabaseDTO after findByName==" + d);
        if (d != null) {
            final Long id = d.getId();
            Assert.assertNotNull(id, "The object found should have an ID");
        } else {
            Assert.assertNull(d, "There is no such object");
        }
    }

    // converting string array to a List of Floats
    // @Test
    public void getDaysArrayList() {
        final String daysArray = "1,1,6,12,12,12,12,12,2";
        final String[] items = daysArray.split(",");
        final Float[] floatArray = new Float[items.length];
        int j = 0;
        for (int i = 0; i < items.length; i++) {
            floatArray[j++] = new Float(Float.parseFloat(items[i]));
        }
        final List<Float> result = Arrays.asList(floatArray);
        Assert.assertEquals(9, result.size());
    }

}
