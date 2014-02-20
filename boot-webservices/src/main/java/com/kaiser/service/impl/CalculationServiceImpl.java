package com.kaiser.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.sc.calc.Engine;
import org.sc.calc.domain.DatedEffort;
import org.sc.calc.domain.EnvType;
import org.sc.calc.domain.Region;
import org.sc.calc.domain.Resources;
import org.sc.calc.domain.Service;
import org.sc.calc.domain.Task;
import org.sc.calc.domain.TaskState;
import org.sc.crud.ResourceApi;
import org.sc.crud.TaskApi;
import org.sc.crud.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import com.kaiser.service.CalculationService;

public class CalculationServiceImpl implements CalculationService {

    @Autowired
    private TaskApi taskApi;

    @Autowired
    private ResourceApi resourceApi;

    @Override
    public Map<String, List<DatedEffort>> getStaffUtilization(final Date startDate, final Date endDate, final Iterable<String> inputRegions,
            final Iterable<String> environments) {
        final List<org.sc.crud.model.Task> taskEntities = taskApi.findByStartEndDate(startDate, endDate);
        final List<Service> services = new ArrayList<>();
        final List<Task> tasks = new ArrayList<>();
        for (final org.sc.crud.model.Task taskEntity : taskEntities) {
            final Task transformedTask = transformTask(taskEntity);
            tasks.add(transformedTask);

            final org.sc.crud.model.Service service = taskEntity.getService();
            final Service transformedService = transformService(service);
            services.add(transformedService);
        }

        Integer staffCount = 0;
        Double hoursPerStaff = 0.0;

        final List<Resource> resourceEntities = resourceApi.findByStartEndDate(startDate, endDate);
        for (final Resource resourceEntity : resourceEntities) {
            hoursPerStaff += resourceEntity.getHours_per_staff();
            staffCount += resourceEntity.getNo_of_staffs();
        }
        // TODO what's the effective date?
        final Date effectiveDate = endDate;
        final Resources resources = new Resources(hoursPerStaff, staffCount, effectiveDate);
        final List<Region> regions = new ArrayList<>();
        return Engine.calcEffort(tasks, services, regions, startDate, endDate, resources);
    }

    private Task transformTask(final org.sc.crud.model.Task taskEntity) {
        final EnvType envType = null;
        final String serviceId = null;
        final Integer envCount = null;
        final String description = null;
        final String CRQ = null;
        final Region region = null;
        final Date startDate = null;
        final TaskState state = null;
        final Task task = new Task(state, startDate, region, CRQ, description, envCount, serviceId, envType);
        return task;
    }

    private Service transformService(final org.sc.crud.model.Service serviceEntity) {
        final List<Float> efforts = serviceEntity.getDaysArrayList();
        final String description = serviceEntity.getDescription();
        final String id = String.valueOf(serviceEntity.getId());
        final Service transformedService = new Service(id, description, efforts);
        return transformedService;
    }
}
