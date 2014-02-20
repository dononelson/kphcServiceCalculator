package org.sc.crud.service;

import java.util.List;

import org.sc.crud.ServiceApi;
import org.sc.crud.model.Service;
import org.sc.crud.repo.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;

// implementation for service interface

public class ServiceApiImpl implements ServiceApi {
    @Autowired
    ServiceRepo dao;

    @Override
    public Service findById(final Long id) {
        return (dao.findById(id));
    }

    @Override
    public List<Service> findAll() {
        return dao.findAll();
    }

}
