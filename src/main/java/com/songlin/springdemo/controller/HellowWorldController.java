package com.songlin.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.classic.Logger;

@Controller
public class HellowWorldController {
//	private static Logger logger = Logger.getLogger(Application.class);
	
	
	@RequestMapping("/hello")
	public String sayHello(@RequestParam(value = "name",required = false, defaultValue = "sb")String name ,Model model){
		
		model.addAttribute("name", name);
		System.out.println("2222");
		return "sayHello";
	}
	
}
