package com.nagarro.nagp.account.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.nagp.account.dtos.LoginDto;
import com.nagarro.nagp.account.entities.User;
import com.nagarro.nagp.account.userdb.UserData;

@Repository
public class AccountRepository {

	@Autowired
	UserData userData;

	public List<User> getAllUsers() {

		return userData.getAllUsers();

	}

	public User getUserById(String id) {

		for (User user : userData.getAllUsers()) {
			if (user.getId().equals(id))
				return user;
		}
		return null;
	}

	public User getUserByUserName(String userName) {

		for (User user : userData.getAllUsers()) {
			if (user.getUserName().equals(userName))
				return user;
		}
		return null;
	}

	public void addUser(User user) {

		userData.addUser(user);
	}

	public void deleteUser(String id) {
		userData.getAllUsers().removeIf(user -> user.getId().equals(id));
	}

	public void updateUser(User updateUser) {
		userData.getAllUsers().removeIf(user -> user.getId().equals(updateUser.getId()));
		userData.getAllUsers().add(updateUser);
	}

	public User loginUser(LoginDto login) {
		return userData.getAllUsers().stream().filter(user -> user.getUserName().equals(login.getUsername())
				&& user.getPassword().equals(login.getPassword())).findFirst().get();

	}

	public User findByEmail(String email) {
		for (User user : userData.getAllUsers()) {
			if (user.getEmail().equals(email))
				return user;
		}
		return null;
	}
}
