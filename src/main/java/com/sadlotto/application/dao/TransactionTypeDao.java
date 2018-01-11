package com.sadlotto.application.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.sadlotto.application.model.Transaction;
import com.sadlotto.application.model.TransactionType;
import com.sadlotto.application.model.User;

@Transactional
public interface TransactionTypeDao extends CrudRepository<TransactionType, Long> {


} 
