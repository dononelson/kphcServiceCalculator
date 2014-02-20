package org.sc.crud;

import java.util.Date;
import java.util.List;

import org.sc.crud.model.Resource;

public interface ResourceApi {
    List<Resource> findByStartEndDate(Date startDate, Date endDate);
}
