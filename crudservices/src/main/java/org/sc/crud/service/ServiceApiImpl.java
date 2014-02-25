package org.sc.crud.service;

import java.util.List;

import org.sc.crud.ServiceApi;
import org.sc.crud.model.Task;
import org.sc.crud.repo.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// implementation for service interface
@Service("serviceApi")
public class ServiceApiImpl implements ServiceApi {
	@Autowired ServiceRepo dao;
	
	public org.sc.crud.model.Service findById(Long id) {
		return (dao.findById(id));
	}
	
	public List<org.sc.crud.model.Service> findAll() {
		return dao.findAll();
	}


	@Override
	public void save(org.sc.crud.model.Service service) {
		dao.save(service);
	}	

}
