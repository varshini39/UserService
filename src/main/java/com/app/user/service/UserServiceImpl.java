package com.app.user.service;

import com.app.user.entity.User;
import com.app.user.exception.IdNotFoundException;
import com.app.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@Override
	public User findById(int userId) {
		Optional<User> searchUser = userRepository.findById(userId);
		
		User user = null;
		if(searchUser.isPresent()) {
			user = searchUser.get();
		} else {
			throw new IdNotFoundException("Did not find the user id - " + userId);
		}
		return user;
	}
	
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public void deleteById(int userId) {
		userRepository.deleteById(userId);
	}
}
