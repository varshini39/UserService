package com.app.user.rest;

import com.app.user.entity.User;
import com.app.user.exception.IdNotFoundException;
import com.app.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

	private UserService userService;
	
	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<User> findAll() {
		return userService.findAll();
	}
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable int userId) {
		User user = userService.findById(userId);
		if(user == null) {
			throw new IdNotFoundException("User ID not found - " + userId);
		}
		return user;
	}
	
	@PostMapping
	public User addUser(@RequestBody User user) {
		user.setUser_id(0);
		User newUser = userService.save(user);
		return newUser;
	}
	
	@PutMapping
	public User updateUser(@RequestBody User user) {
		User updatedUser = userService.save(user);
		return updatedUser;
	}
	
	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable int userId) {
		User user = userService.findById(userId);
		if(user == null) {
			throw new IdNotFoundException("User ID not found - " + userId);
		}
		userService.deleteById(userId);
		return "Deleted user ID - " + userId;
	}
}
