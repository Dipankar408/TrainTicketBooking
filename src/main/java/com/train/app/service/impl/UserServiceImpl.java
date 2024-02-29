package com.train.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.app.entity.User;
import com.train.app.repo.UserRepo;
import com.train.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User getUser(Long id) {
		return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public String deleteUser(Long id) {
		User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		userRepo.delete(user);
		return "Record deleted";
	}

}
