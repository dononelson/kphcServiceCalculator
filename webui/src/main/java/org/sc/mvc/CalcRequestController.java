package org.sc.mvc;

import java.util.Iterator;
import java.util.Set;

import org.sc.mvc.command.CalcRequestCommand;
import org.sc.mvc.model.CalcResponse;
import org.sc.mvc.wsresponse.DateResult;
import org.sc.mvc.wsresponse.StaffUtilizationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestOperations;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 
 * Note - can use this for populating drop-downs, etc.
 */

@Controller
public class CalcRequestController {

    @Autowired
    private RestOperations restOps;

    @RequestMapping(value = "/calcRequest", method = RequestMethod.GET)
    public ModelAndView handleGet() {
        final ModelAndView mv = new ModelAndView();
        mv.setViewName("calcRequest");
        mv.addObject(new CalcRequestCommand());
        return mv;
    }

    @RequestMapping(value = "/calcResult", method = RequestMethod.POST)
    public ModelAndView handlePost(final CalcRequestCommand command) {
        final ModelAndView mv = new ModelAndView();
        final UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
        builder.queryParam("startDate", command.getStartDate());
        builder.queryParam("endDate", command.getEndDate());
        builder.queryParam("regions", command.getRegion()).queryParam("envTypes", command.getEnvType());
        final String uri = builder.build().encode().toUriString();
        mv.setViewName("calcResult");
        final StaffUtilizationResult staffResult = restOps.getForObject(uri, StaffUtilizationResult.class);
        mv.addObject(staffResult);

        final CalcResponse response = new CalcResponse();
        populateResponse(response, staffResult, command);

        mv.addObject(response);

        return mv;
    }

    protected void populateResponse(final CalcResponse response, final StaffUtilizationResult result, final CalcRequestCommand request) {
        response.setTitle("Calculation Results");
        response.setEndDate(request.getEndDate());
        response.setStartDate(request.getStartDate());
        response.setEnvType(request.getEnvType());
        response.setEnvNum(request.getEnvNum());
        final Set<org.sc.mvc.wsresponse.RegionResult> resultSet = result.getRegionResults();
        final Iterator<org.sc.mvc.wsresponse.RegionResult> it = resultSet.iterator();
        Set<DateResult> dateResultSet = null;

        while (it.hasNext()) {
            final org.sc.mvc.wsresponse.RegionResult regResult = it.next();
            dateResultSet = regResult.getDateResults();
            response.setRegion(regResult.getRegion());
            break;
        }

        for (final Iterator<DateResult> iterator = dateResultSet.iterator(); iterator.hasNext();) {
            final DateResult dateResult = iterator.next();
            response.setDate(dateResult.getDate());
            response.setHours(dateResult.getAmount());
            break;
        }
    }

}
