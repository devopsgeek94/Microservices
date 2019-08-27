/**
 * 
 */
package com.lifetolearn.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lifetolearn.application.domain.Credentials;
import com.lifetolearn.application.domain.User;
import com.lifetolearn.application.service.UserService;

/**
 * @author Prateek Maurya
 * 		   since 26-Aug-2019
 */
@CrossOrigin
@RestController
@RequestMapping("/mylearning")
public class Controller {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/ping")
	public ResponseEntity<String> ping(){
		return new ResponseEntity<String>("Successfully connected to the service",HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user){
		return new ResponseEntity<User>(userService.register(user),HttpStatus.OK);
	}
	
	@GetMapping("/getUser/{username}")
	public ResponseEntity<User> getUser(@PathVariable String username){
		return new ResponseEntity<User>(userService.getByUsername(username),HttpStatus.OK);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(userService.getAll(),HttpStatus.OK);
	}
	
	@PutMapping("/updatePassword")
	public ResponseEntity<String> updatePassword(@RequestBody Credentials credentials){
		return new ResponseEntity<String>(userService.updatePassword(credentials),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser/{username}")
	public ResponseEntity<Long> deleteUser(@PathVariable String username){
		return new ResponseEntity<Long>(userService.deleteByUsername(username),HttpStatus.OK);
	}
	
}
