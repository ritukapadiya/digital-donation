package com.royal.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.royal.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID>{

}
