package com.sadlotto.application.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.sadlotto.application.model.User;

@Transactional
public interface UserDao extends CrudRepository<User, Long> {

    public List<User> findAll();

} 
