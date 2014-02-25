package org.sc.crud.repo;



import org.sc.crud.model.Service;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


//Repository interface for Service
@Repository
public interface ServiceRepo extends RepoBase<Service, Long> {

	@Transactional(readOnly = true)
	@Query("SELECT t FROM Service t  WHERE t.id = :serviceId")
	Service findById(
			@Param("serviceId") Long serviceId);

}

