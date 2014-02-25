package org.sc.crud.service;

import org.sc.crud.TaskApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@ContextConfiguration("classpath:/test-app-context.xml")
public class TaskApiTest extends  AbstractTransactionalTestNGSpringContextTests{
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(TaskApiTest.class);

	/** The dao. */
	@Autowired
	private TaskApi taskApi;
    // test using findAll service api
	@Test
	public void testFindAll() {
		int i = -1; 
		int size = taskApi.findAll().size();
		Assert.assertNotEquals(i, size);
	}
	
	
}
