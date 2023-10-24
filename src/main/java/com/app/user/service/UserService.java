package com.app.user.service;


import com.app.project.entity.User;

import java.util.List;

public interface UserService {

	List<User> findAll();
	User findById(int userId);
	User save(User user);
	void deleteById(int userId);
	
}
