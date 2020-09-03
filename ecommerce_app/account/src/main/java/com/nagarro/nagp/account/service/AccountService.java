package com.nagarro.nagp.account.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.nagarro.nagp.account.entities.User;

public interface AccountService {

	List<User> getAllUsers();

	User getUser(String id);

	ResponseEntity<String> addUser(User User);

	ResponseEntity<String> deleteUser(String id);

}