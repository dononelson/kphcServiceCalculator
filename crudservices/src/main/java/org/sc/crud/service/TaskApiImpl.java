package org.sc.crud.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.sc.crud.TaskApi;
import org.sc.crud.model.Task;
import org.sc.crud.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

// implementation for service interface
@Service("taskApi")
public class TaskApiImpl implements TaskApi {
    @Autowired
    TaskRepo dao;

    @Override
    public Task findById(final Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Task> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Task> findByStartEndDate(final Date startDate, final Date endDate) {
        final List<Task> tasks = new ArrayList<>();
        return tasks;
    }

    public void save(Task task) {
        dao.save(task);
    }
}
