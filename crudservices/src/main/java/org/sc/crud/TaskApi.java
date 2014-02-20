package org.sc.crud;

import java.util.Date;
import java.util.List;

import org.sc.crud.model.Task;

// exposed service calls
public interface TaskApi {
    Task findById(Long id);

    List<Task> findAll();

    List<Task> findByStartEndDate(Date startDate, Date endDate);
}
