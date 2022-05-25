package com.poc.shoecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.shoecart.entity.User;
import com.poc.shoecart.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/allUsers")
	public ResponseEntity<List<User>> getAllUsers() {

		List<User> user = null;

		try {
			user = userService.getallUsers();
		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}

	@GetMapping("/getUserById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long userId) {

		User user = null;

		try {
			user = userService.getUserById(userId);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	@PostMapping("/addOrUpdate")
	public ResponseEntity<User> addorUpdate(@RequestBody User user) {

		User user = null;

		try {
			user = userService.addOrUpdateUser(user);
		} catch (Exception ex) {
			ex.getMessage();
		}

		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") long userId) {

		User user = null;

		try {
			user = userService.deleteUser(userId);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
