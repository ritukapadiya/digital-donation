package com.royal.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
@Table(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String gender;
	private String contactNumber;
	private String address;
	private String state;
	private String city;
	private Integer pincode;
	private Integer activeInd;
	private LocalDateTime createdAt;
	private String profilePath;
	private String role;
	
	  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	  @JoinColumn(name = "user_id")
	List<DonationEntity> donations;
 
	
}
