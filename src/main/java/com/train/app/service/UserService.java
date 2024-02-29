package com.train.app.service;

import com.train.app.entity.User;

public interface UserService {

	public User addUser(User user);
	
	public User getUser(Long id);
	
	public User updateUser(User user);
	
	public String deleteUser(Long id);
}
