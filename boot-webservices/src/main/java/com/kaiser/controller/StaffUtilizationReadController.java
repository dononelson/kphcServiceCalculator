package com.kaiser.controller;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaiser.controller.response.RegionResult;
import com.kaiser.controller.response.StaffUtilizationResult;

@Controller
public class StaffUtilizationReadController {

    @ResponseBody
    @RequestMapping(value = "/staffUtilization", method = RequestMethod.GET)
    public StaffUtilizationResult getStaffUtilization(@RequestParam(required = false) final String startDate,
            @RequestParam(required = false) final String endDate, @RequestParam(required = false) final String envType,
            @RequestParam(required = false) final String region, @RequestParam(required = false) final Integer instances) {
        final StaffUtilizationResult result = new StaffUtilizationResult();
        final Set<RegionResult> regionResults = result.getRegionResults();
        final RegionResult regionResult = new RegionResult();
        regionResults.add(regionResult);
        return result;
    }

}
