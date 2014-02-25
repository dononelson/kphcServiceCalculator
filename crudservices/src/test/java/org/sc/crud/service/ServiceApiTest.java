package org.sc.crud.service;
import org.sc.crud.ServiceApi;
import org.sc.crud.model.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@ContextConfiguration("classpath:/test-app-context.xml")
public class ServiceApiTest extends  AbstractTransactionalTestNGSpringContextTests{
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ServiceApiTest.class);

	/** The dao. */
	@Autowired
	private ServiceApi serviceApi;
    // test using findAll service api

	@Test
	public void testFindAll() {
		int i = -1;
		int size = serviceApi.findAll().size();
		Assert.assertNotEquals(i, size);
	}
	@Test
	public void testFindById() {
		Service theService = serviceApi.findById(100L);
		Assert.assertNotNull(theService);
	}	
	
}
