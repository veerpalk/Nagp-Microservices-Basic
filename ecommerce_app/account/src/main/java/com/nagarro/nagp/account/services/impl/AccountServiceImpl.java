package com.nagarro.nagp.account.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.account.entities.User;
import com.nagarro.nagp.account.repository.AccountRepository;
import com.nagarro.nagp.account.service.AccountService;

@Service(value = "userService")
public class AccountServiceImpl implements AccountService, UserDetailsService {
	Logger logger = LogManager.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public List<User> getAllUsers() {
		return accountRepository.getAllUsers();
	}

	@Override
	public User getUser(String id) {
		return accountRepository.getUserById(id);
	}

	@Override
	public ResponseEntity<String> addUser(User user) {
		User userWithDuplicateUsername = accountRepository.getUserByUserName(user.getUserName());
		if (userWithDuplicateUsername != null && user.getId() != userWithDuplicateUsername.getId()) {
			logger.error(String.format("Duplicate username %", user.getUserName()));
			throw new RuntimeException("Duplicate username.");
		}

		User userWithDuplicateEmail = accountRepository.findByEmail(user.getEmail());
		if (userWithDuplicateEmail != null && user.getId() != userWithDuplicateEmail.getId()) {
			logger.error(String.format("Duplicate email %", user.getEmail()));
			throw new RuntimeException("Duplicate email.");
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setId(UUID.randomUUID().toString());
		accountRepository.addUser(user);
		logger.info("Created new user");
		return new ResponseEntity<String>("User added successfully", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteUser(String id) {
		accountRepository.deleteUser(id);
		return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = accountRepository.getUserByUserName(userName);
		if (user == null) {
			// log.error("Invalid username or password.");
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		Set<SimpleGrantedAuthority> grantedAuthorities = getAuthorities(user);

		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				grantedAuthorities);

	}

	private Set<SimpleGrantedAuthority> getAuthorities(User user) {

		final Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().toString()));
		return authorities;

	}

}
