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

import com.kaiser.controller.response.RegionResult;

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
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calcRequest");
		mv.addObject(new CalcRequestCommand());
		return mv;
	}

	@RequestMapping( value="/calcResult", method = RequestMethod.POST)
	public ModelAndView handlePost(CalcRequestCommand command) {
		ModelAndView mv = new ModelAndView();
		UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
		builder.queryParam("startDate", command.getStartDate());
		builder.queryParam("endDate", command.getEndDate());
		builder.queryParam("regions", command.getRegion()).queryParam("envTypes", command.getEnvType());
		String uri = builder.build().encode().toUriString();
		mv.setViewName("calcResult");
		StaffUtilizationResult staffResult = restOps.getForObject(uri, StaffUtilizationResult.class);
		mv.addObject(staffResult);
		
		CalcResponse response = new CalcResponse();
		populateResponse(response, staffResult, command);
		
		mv.addObject(response);
		
		return mv;
	}

	protected void populateResponse(CalcResponse response, StaffUtilizationResult result, CalcRequestCommand request) {
		response.setTitle("Calculation Results");
		response.setEndDate(request.getEndDate());
		response.setStartDate(request.getStartDate());
		response.setEnvType(request.getEnvType());
		response.setEnvNum(request.getEnvNum());
		Set<org.sc.mvc.wsresponse.RegionResult> resultSet = result.getRegionResults();
		Iterator<org.sc.mvc.wsresponse.RegionResult> it = resultSet.iterator();
		Set<DateResult> dateResultSet = null;
		
		while (it.hasNext()) {
			org.sc.mvc.wsresponse.RegionResult regResult = it.next();
			dateResultSet = regResult.getDateResults();
			response.setRegion(regResult.getRegion());
			break;
		}
		
		for (Iterator<DateResult> iterator = dateResultSet.iterator(); iterator.hasNext();) {
			DateResult dateResult = iterator.next();
			response.setDate(dateResult.getDate());
			response.setHours(dateResult.getAmount());
			break;
		}
	}

}
