package org.sc.crud.repo;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.sc.crud.model.Service;
import org.sc.crud.model.Task;
import org.sc.crud.repo.ServiceRepo;
import org.sc.crud.repo.TaskRepo;
import org.sc.crud.exception.RepoException;

@ContextConfiguration("classpath:/test-app-context.xml")
public class TaskRepoTest extends  AbstractTransactionalTestNGSpringContextTests{
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(TaskRepoTest.class);

	/** The dao. */
	@Autowired
	private TaskRepo dao;
	@Autowired 
	private ServiceRepo serviceDao;

	// test saving a task to database
	@Test
	public void testSave() {
		Task newTask = new Task();
		newTask.setActivity_desc("KPHC CO - TESTCO3 refresh from TESTCO6");
		newTask.setCRQ_no("CRQ000000153222");
		newTask.setEnv_type("NP");
		newTask.setNo_of_env((short)1);
		newTask.setRegion("CO");
		//newTask.setService
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 03, 1); // March 1st 2014
		Date startDate = cal.getTime();		
		newTask.setStart_Date(startDate);
		// This task is a task of Service with id = 1
		long serviceId = 1;
		Service theService = serviceDao.findById(serviceId);
		// 
		newTask.setService(theService);
		dao.saveAndFlush(newTask);
	}
	
	@Test
	public void testFindById()  {
		LOGGER.info("Starting testFindById test");
		long taskId = 1;
		Task d = dao.findById(taskId);
		LOGGER.info("DatabaseDTO after findByName==" + d);
		if (d != null) {
			Long id = d.getId();
			Assert.assertNotNull(id, "The object found should have an ID");
		} else {
			Assert.assertNull(null, "The task id is not found");
		}
	}

}
