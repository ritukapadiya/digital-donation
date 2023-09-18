package com.royal.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.royal.entity.UserEntity;
import com.royal.repository.UserRepository;

//private methods here
@RestController
public class UserController {

	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers(){
		List<UserEntity> users = userRepo.findAll();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<?> getAllUserById(@PathVariable("userId") UUID uid){
//		Optional is used to represent a value that may or may not be present. 
//		In other words, an Optional object can either contain a non-null value (in which case it is considered present) 
//		or it can contain no value at all (in which case it is considered empty).

		Optional<UserEntity> optUser = userRepo.findById(uid);
		if(optUser.isPresent()) {
			UserEntity user = optUser.get();
			return ResponseEntity.ok(user);
		}
		else {
			return ResponseEntity.ok(uid);
		}
		
	}
	
	@GetMapping("/deleteuser/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") UUID userId){
		userRepo.deleteById(userId);
		List<UserEntity> users = userRepo.findAll();
		return ResponseEntity.ok(users);
	}
	
	
	@PutMapping("/updateuser")
	public ResponseEntity<?> updateUser(@RequestBody UserEntity user){
//		if userId already exists, it will update the data by given data.
//		if userId not present then it will insert the data.
		userRepo.save(user);
		return ResponseEntity.ok(user);
	}
	
}
