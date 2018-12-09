package com.zhengshr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user.do")
public class UserController {

	@RequestMapping(value="login", method=RequestMethod.GET)
	public String loginin() {
		return "home";
	}
	
	
}
