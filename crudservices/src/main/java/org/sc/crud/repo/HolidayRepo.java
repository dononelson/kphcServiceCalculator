package org.sc.crud.repo;

import org.sc.crud.model.Holiday;
import org.springframework.stereotype.Repository;

//Repository interface for Holiday
@Repository
public interface HolidayRepo extends RepoBase<Holiday, Long> {

}
