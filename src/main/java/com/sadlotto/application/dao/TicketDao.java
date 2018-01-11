package com.sadlotto.application.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.sadlotto.application.model.Ticket;

@Transactional
public interface TicketDao extends CrudRepository<Ticket, Long> {

    

} 
