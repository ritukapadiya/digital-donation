package com.royal.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.royal.bean.LoginBean;
import com.royal.entity.UserEntity;
import com.royal.repository.UserRepository;

@RestController
@RequestMapping("/public")
public class SessionController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BCryptPasswordEncoder encoder; 
	
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody UserEntity user){
		user.setActiveInd(1);
		LocalDateTime date = LocalDateTime.now();
		user.setCreatedAt(date);
		user.setPassword(encoder.encode(user.getPassword()));
		
		userRepo.save(user);//insert
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginBean loginBean){
		
		List<UserEntity> users = userRepo.findAll();
		
		for(UserEntity user:users) {
			if(user.getEmail().equals(loginBean.getEmail())) {
				if(encoder.matches(loginBean.getPassword(), user.getPassword())) {
					return ResponseEntity.ok(user);
				}
			}
		}
		
		return ResponseEntity.ok(loginBean);
		
	}

}
