package org.sc.crud.repo;

import org.sc.crud.model.Resource;
import org.springframework.stereotype.Repository;

//Repository interface for Resource
@Repository
public interface ResourceRepo extends RepoBase<Resource, Long> {

}
