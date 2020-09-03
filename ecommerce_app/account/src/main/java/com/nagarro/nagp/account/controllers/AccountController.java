package com.nagarro.nagp.account.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.account.entities.User;
import com.nagarro.nagp.account.service.AccountService;
import com.nagarro.nagp.account.service.AdminService;

@RestController
@RequestMapping(value = "/account")
public class AccountController {
	
	public static final String ROLE_DELIVERY_TEAM = "ROLE_DELIVERY_TEAM";

	@Autowired
	private AccountService accountService;
	
	
	@Autowired
	private AdminService adminService;

	@GetMapping("")
	public List<User> getAllUsers() {
		return accountService.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") String id) {
		return accountService.getUser(id);
	}

	@PostMapping("")
	public void addUser(@RequestBody User User) {
		accountService.addUser(User);
	}

	@PutMapping("")
	public void updateUser(@RequestBody User User) {

	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") String id) {
		accountService.deleteUser(id);
	}

}
