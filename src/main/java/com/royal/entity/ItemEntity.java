package com.royal.entity;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="item")
public class ItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID itemId;
	private String itemName;
	private Integer activeInd;
	
//	many items have 1 categoryId
//	many to 1
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "category_id")
	CategoryEntity category=new CategoryEntity();
	
//	1 item have many donations
//	@JsonManagedReference
//	@OneToMany(mappedBy = "item",fetch = FetchType.LAZY) //category is object in ItemEntity
	//List<DonationEntity> donations;

	public UUID getItemId() {
		return itemId;
	}

	public void setItemId(UUID itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getActiveInd() {
		return activeInd;
	}

	public void setActiveInd(Integer activeInd) {
		this.activeInd = activeInd;
	}


	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

//	public List<DonationEntity> getDonations() {
//		return donations;
//	}
//
//	public void setDonations(List<DonationEntity> donations) {
//		this.donations = donations;
//	}
	
	
}
