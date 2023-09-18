package com.royal.entity;

import java.time.LocalDateTime;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="donation")
public class DonationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID donationId;
	private LocalDateTime date;
	private Integer assignInd;
	private Integer statusInd;
	private String title;
	private String keywords;
	private String description;
 
//	many donation has 1 user
//	@JsonBackReference
//	@ManyToOne
//	@JoinColumn(name = "user_id")
//	UserEntity user = new UserEntity();
	
//	many donation has 1 category
//	@JsonBackReference
//	@ManyToOne
//	@JoinColumn(name = "category_id")
//	CategoryEntity categoryy = new CategoryEntity();

	public UUID getDonationId() {
		return donationId;
	}

	public void setDonationId(UUID donationId) {
		this.donationId = donationId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getAssignInd() {
		return assignInd;
	}

	public void setAssignInd(Integer assignInd) {
		this.assignInd = assignInd;
	}

	public Integer getStatusInd() {
		return statusInd;
	}

	public void setStatusInd(Integer statusInd) {
		this.statusInd = statusInd;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public UserEntity getUser() {
//		return user;
//	}
//
//	public void setUser(UserEntity user) {
//		this.user = user;
//	}
//
//	public CategoryEntity getCategory() {
//		return categoryy;
//	}
//
//	public void setCategory(CategoryEntity category) {
//		this.categoryy = category;
//	}
	

//	many donation has 1 item
//	@JsonBackReference
//	@ManyToOne
	//@JoinColumn(name = "item_id")
	//ItemEntity item = new ItemEntity();


 
	
	

}
