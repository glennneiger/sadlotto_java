package com.sadlotto.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sadlotto.application.dao.UserDao;
import com.sadlotto.application.model.NumberGroup;
import com.sadlotto.application.model.Ticket;

@RestController(value="/ticket")
public class TicketController {

	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/ticket/create", method=RequestMethod.GET)
	public ModelAndView create()
	{
		Ticket ticket = new Ticket();
		ticket.setIsPowerplay(true);
		List<NumberGroup> numberGroupList = new ArrayList<>();
		numberGroupList.add(new NumberGroup());
		numberGroupList.add(new NumberGroup());
		numberGroupList.add(new NumberGroup());
		ticket.setNumberGroups(numberGroupList);
				
		ModelAndView mv = new ModelAndView("/tickets/create");
		mv.addObject("ticket", ticket);
		mv.addObject("users", userDao.findAll());
		return mv;
	}
	
	@RequestMapping(value="/ticket/create", method=RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute Ticket ticket)
	{
		
		ModelAndView mv = new ModelAndView("/home");		
		return mv;
	}

}
