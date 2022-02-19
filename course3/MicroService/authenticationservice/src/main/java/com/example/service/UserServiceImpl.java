package com.example.service;

import java.util.List;

import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.exception.UserNotFoundException;
import com.example.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public User registerUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) throws UserNotFoundException {
		User user = userRepo.findByUsernameAndPassword(username, password);
		if(user == null) {
			throw new UserNotFoundException();
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
}
