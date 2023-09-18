package com.royal.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.royal.entity.CategoryEntity;
import com.royal.repository.CategoryRepository;

@RestController
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepo;
	
	
	@PostMapping("/addcategory")
	public ResponseEntity<?> addCategory(@RequestBody CategoryEntity category){
		categoryRepo.save(category);
		return ResponseEntity.ok(category);
	}
	
	@GetMapping("/categories")
	public ResponseEntity<?> allCategory(){
		List<CategoryEntity> categories = categoryRepo.findAll();
		return ResponseEntity.ok(categories);
	}
	
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<?> categoryById(@PathVariable("categoryId") UUID cid){
		Optional<CategoryEntity> optional = categoryRepo.findById(cid);
		if(optional.isPresent()) {
			CategoryEntity category = optional.get();	
			return ResponseEntity.ok(category);
		}
		else {
			return ResponseEntity.ok(cid);
		}
	}
	
	@GetMapping("/deletecategory/{categoryId}")
	public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") UUID cid){
		categoryRepo.deleteById(cid);
		List<CategoryEntity> categories = categoryRepo.findAll();
		return ResponseEntity.ok(categories);
		
	}
	
	@PutMapping("/updatecategory")
	public ResponseEntity<?> updateCategory(@RequestBody CategoryEntity category){
		categoryRepo.save(category);
		return ResponseEntity.ok(category);
	}
}
