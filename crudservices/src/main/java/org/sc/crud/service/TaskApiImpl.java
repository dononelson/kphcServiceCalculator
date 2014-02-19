package org.sc.crud.service;

import java.util.List;

import org.sc.crud.ServiceApi;
import org.sc.crud.TaskApi;
import org.sc.crud.model.Service;
import org.sc.crud.model.Task;
import org.sc.crud.repo.ServiceRepo;
import org.sc.crud.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
// implementation for service interface
public class TaskApiImpl implements TaskApi {
	@Autowired TaskRepo dao;
	
	public Task findById(Long id) {
		return (dao.findById(id));
	}

	public List<Task> findAll() {
		return dao.findAll();
	}

}
