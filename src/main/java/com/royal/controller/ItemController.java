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

import com.royal.entity.ItemEntity;
import com.royal.repository.ItemRepository;

@RestController
public class ItemController {
	
	@Autowired
	ItemRepository itemRepo;
	
	@PostMapping("/additem")
	public ResponseEntity<?> addItem(@RequestBody ItemEntity item){
		item.setActiveInd(1);
		System.out.println(item.getCategory());
		System.out.println(item.getCategory().getCategoryId());
		
		System.out.println(item.getCategory().getCategoryName());
		
		itemRepo.save(item);
		return ResponseEntity.ok(item);
		
	}
	
	@GetMapping("/items")
	public ResponseEntity<?> getAllItem(){
		List<ItemEntity> items = itemRepo.findAll();
		return ResponseEntity.ok(items);
	}
	
	@GetMapping("/items/{itemId}")
	public ResponseEntity<?> getItem(@PathVariable UUID itemId){
		Optional<ItemEntity> optional = itemRepo.findById(itemId);
		if(optional.isPresent()) {
			ItemEntity item = optional.get();
			System.out.println(item.getCategory().getCategoryName());
			return ResponseEntity.ok(item);
		}
		else {
			return ResponseEntity.ok(itemId);
		}
		
	}
	
	@GetMapping("/deleteitem/{itemId}")
	public ResponseEntity<?> deleteItem(@PathVariable UUID itemId){
		itemRepo.deleteById(itemId);
		List<ItemEntity> items = itemRepo.findAll();
		return ResponseEntity.ok(items);
	}
	
	@PutMapping("/updateitem")
	public ResponseEntity<?> updateItem(@RequestBody ItemEntity item){
		itemRepo.save(item);
		return ResponseEntity.ok(item);
	}
}
