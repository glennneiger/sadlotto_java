package com.sadlotto.application.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.sadlotto.application.model.NumberGroup;

@Transactional
public interface NumberGroupDao extends CrudRepository<NumberGroup, Long> {

    

} 
