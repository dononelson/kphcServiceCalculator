package org.sc.crud.repo;

import org.sc.crud.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//Repository interface for Task
@Repository
public interface TaskRepo extends RepoBase<Task, Long> {

    @Transactional(readOnly = true)
    @Query("SELECT t FROM Task t  WHERE t.id = :taskId")
    Task findById(@Param("taskId") Long taskId);

}
