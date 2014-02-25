package org.sc.crud;

import java.util.List;

import org.sc.crud.model.Service;
import org.sc.crud.model.Task;
// exposed service calls
public interface ServiceApi {
	Service findById(Long id);	
	List<Service> findAll();
	void save(Service service);
}
