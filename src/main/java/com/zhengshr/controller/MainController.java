package com.zhengshr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/")
	public String index() {
		logger.debug("~~~~~~~~~~~~~ main controller: index!!!");
		return "index";
	}
}
