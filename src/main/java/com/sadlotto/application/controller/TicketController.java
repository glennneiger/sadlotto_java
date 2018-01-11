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

import com.sadlotto.application.dao.NumberGroupDao;
import com.sadlotto.application.dao.TicketDao;
import com.sadlotto.application.dao.TransactionTypeDao;
import com.sadlotto.application.dao.UserDao;
import com.sadlotto.application.model.NumberGroup;
import com.sadlotto.application.model.Ticket;
import com.sadlotto.application.model.Transaction;
import com.sadlotto.application.model.User;

@RestController(value="/ticket")
public class TicketController {

	@Autowired
	private TicketDao ticketDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private NumberGroupDao numberGroupDao;
	
	@Autowired
	private TransactionTypeDao transactionTypeDao;
	
	@RequestMapping(value="/ticket/create", method=RequestMethod.GET)
	public ModelAndView create()
	{
		Ticket ticket = new Ticket();	
		List<User> users = userDao.findAll();
		List<NumberGroup> numberGroupList = new ArrayList<>();
		numberGroupList.add(new NumberGroup());
		numberGroupList.add(new NumberGroup());
		numberGroupList.add(new NumberGroup());
		ticket.setNumberGroups(numberGroupList);
		
		List<Transaction> transactions = new ArrayList<>();
		for(User user : users)
		{
			Transaction t = new Transaction();
			t.setToUser(user);
			transactions.add(t);
		}
		ticket.setTransactions(transactions);
				
		ModelAndView mv = new ModelAndView("/tickets/create");
		mv.addObject("ticket", ticket);
		mv.addObject("users", users);
		mv.addObject("transactionTypes", transactionTypeDao.findAll());
		return mv;
	}
	
	@RequestMapping(value="/ticket/create", method=RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute Ticket ticket)
	{
		ticketDao.save(ticket);
		
		for(NumberGroup ng : ticket.getNumberGroups())
		{
			ng.setTicket(ticket);
			numberGroupDao.save(ng);
		}
		
		ModelAndView mv = new ModelAndView("/home");		
		return mv;
	}

}
