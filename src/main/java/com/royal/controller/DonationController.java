package com.royal.controller;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.royal.entity.DonationEntity;
import com.royal.repository.CategoryRepository;
import com.royal.repository.DonationRepository;
import com.royal.repository.UserRepository;

@RestController
public class DonationController {
	
	@Autowired
	DonationRepository donationRepo;
	
	@Autowired 
	UserRepository userRepo;
	
	
	@Autowired
	CategoryRepository categoryRepo;
	@PostMapping("/adddonation")
	public ResponseEntity<?> addDonation(@RequestBody DonationEntity donation){
		donation.setAssignInd(1);
		donation.setStatusInd(1);
		LocalDateTime date = LocalDateTime.now();
		donation.setDate(date);
		
//		   Comment comment = tutorialRepository.findById(tutorialId).map(tutorial -> {
			//      tutorial.getComments().add(commentRequest);
		
		userRepo.findById(UUID.fromString("610a6052-4a56-4316-a090-0258388bda41")).map(user->user.getDonations().add(donation));
		categoryRepo.findById(UUID.fromString("7bdd60fa-99b1-4268-9693-2c1181fee0f0")).map(cat->cat.getDonations().add(donation));
		
		
		donationRepo.save(donation);
		return ResponseEntity.ok(donation);
		
	}
}
