package com.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author RAJASHEKHAR
 *
 */
@Controller
public class LoginController {
	
	@RequestMapping(value = "login" ,method = RequestMethod.GET)
	public String login(){
		return "login";
		
	}

	
	@RequestMapping(value = "error" ,method = RequestMethod.GET)
	public String error(){
		return "error";
		
	}
}
