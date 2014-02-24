package org.sc.crud.repo;

import java.util.Calendar;
import java.util.Date;

import org.sc.crud.model.Service;
import org.sc.crud.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;

@ContextConfiguration("classpath:/META-INF/base-app-context.xml")
public class TaskRepoTest extends AbstractTransactionalTestNGSpringContextTests {
    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskRepoTest.class);

    /** The dao. */
    @Autowired
    private TaskRepo dao;
    @Autowired
    private ServiceRepo serviceDao;

    // test saving a task to database
    // @Test
    public void testSave() {
        final Task newTask = new Task();
        newTask.setActivity_desc("KPHC CO - TESTCO3 refresh from TESTCO6");
        newTask.setCRQ_no("CRQ000000153222");
        newTask.setEnv_type("NP");
        newTask.setNo_of_env((short) 1);
        newTask.setRegion("CO");
        // newTask.setService
        final Calendar cal = Calendar.getInstance();
        cal.set(2014, 03, 1); // March 1st 2014
        final Date startDate = cal.getTime();
        newTask.setStart_Date(startDate);
        // This task is a task of Service with id = 1
        final long serviceId = 1;
        final Service theService = serviceDao.findById(serviceId);
        //
        newTask.setService(theService);
        dao.saveAndFlush(newTask);
    }

    // @Test
    public void testFindById() {
        LOGGER.info("Starting testFindById test");
        final long taskId = 1;
        final Task d = dao.findById(taskId);
        LOGGER.info("DatabaseDTO after findByName==" + d);
        if (d != null) {
            final Long id = d.getId();
            Assert.assertNotNull(id, "The object found should have an ID");
        } else {
            Assert.assertNull(null, "The task id is not found");
        }
    }

}
