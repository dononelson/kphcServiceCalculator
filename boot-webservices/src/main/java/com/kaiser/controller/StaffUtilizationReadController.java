package com.kaiser.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.sc.calc.domain.DatedEffort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaiser.controller.response.DateResult;
import com.kaiser.controller.response.RegionResult;
import com.kaiser.controller.response.StaffUtilizationResult;
import com.kaiser.service.CalculationService;

@Controller
public class StaffUtilizationReadController {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MM-DD-YYYY");

    @Autowired
    private CalculationService calculationService;

    @ResponseBody
    @RequestMapping(value = "/staffUtilization", method = RequestMethod.GET)
    public StaffUtilizationResult getStaffUtilization(@RequestParam(required = true) final String startDate,
            @RequestParam(required = true) final String endDate, @RequestParam(required = false) final String[] regions,
            @RequestParam(required = false) final String[] envTypes) throws ParseException {
        final Date parsedStartDate = dateFormat.parse(startDate);
        final Date parsedEndDate = dateFormat.parse(endDate);

        final Map<String, List<DatedEffort>> staffUtilization = calculationService.getStaffUtilization(parsedStartDate, parsedEndDate, Arrays.asList(regions),
                Arrays.asList(envTypes));
        final StaffUtilizationResult result = new StaffUtilizationResult();
        final Set<RegionResult> regionResults = result.getRegionResults();
        for (final Entry<String, List<DatedEffort>> entry : staffUtilization.entrySet()) {
            final String inputRegion = entry.getKey();
            final RegionResult regionResult = new RegionResult();
            regionResult.setRegion(inputRegion);
            final Set<DateResult> dateResults = regionResult.getDateResults();
            for (final DatedEffort datedEffort : entry.getValue()) {
                final DateResult dateResult = new DateResult();
                dateResult.setAmount(datedEffort.effort);
                dateResult.setDate(datedEffort.date);
                dateResults.add(dateResult);
            }
            regionResults.add(regionResult);
        }
        return result;
    }

}
