package org.sc.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
@RequestMapping("/calcRequest")
public class CalcRequestController {
 
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String getMovie(@PathVariable String name, ModelMap model) {
 
		model.addAttribute("movie", name);
		return "list";
 
	}
 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getDefaultMovie(ModelMap model) {
 
		model.addAttribute("movie", "this is default movie");
		return "list";
 
	}
 
}
