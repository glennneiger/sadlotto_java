package com.sadlotto.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

	@RequestMapping(value="/")
	public ModelAndView index()
	{
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/home")
	public ModelAndView home()
	{
		return new ModelAndView("home");
	}
	
}
