package com.kaiser.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.sc.calc.domain.DatedEffort;

public interface CalculationService {

    /**
     * Returns the calculation for the staff utilization over the period.
     * 
     * @param startDate
     *            start date for the calculation (Inclusive)
     * @param endDate
     *            start date for the calculation (exclusive)
     * @param regions
     * @param environments
     * @return a non null map of Lists that hold the efforts by date. The key is the region.
     */
    public Map<String, List<DatedEffort>> getStaffUtilization(Date startDate, Date endDate, Iterable<String> regions, Iterable<String> environments);

}
