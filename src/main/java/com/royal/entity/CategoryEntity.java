package com.royal.entity;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
 
@Getter
@Setter
@Entity
@Table(name = "category")
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID categoryId;
	private String categoryName;
	
//	1 category has many items
//	1 to many
	
	@JsonManagedReference
	//@JsonIgnore
	@OneToMany(mappedBy = "category",fetch = FetchType.LAZY) //category is object in ItemEntity
	List<ItemEntity> items;
//	
//	@JsonManagedReference
	  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	  @JoinColumn(name = "category_id")
 	List<DonationEntity> donations;
	
	 
	 
	
		
}
