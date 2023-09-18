package com.royal.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.royal.entity.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, UUID>{

}
