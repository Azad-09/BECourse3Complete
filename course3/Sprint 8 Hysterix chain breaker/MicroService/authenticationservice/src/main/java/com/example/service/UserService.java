package com.example.service;

import java.util.List;

import com.example.model.User;
import com.example.exception.UserNotFoundException;

public interface UserService {

	public User registerUser(User user);
	public User findByUsernameAndPassword(String username,String password)throws UserNotFoundException;
	public List<User> getAllUsers();
}
