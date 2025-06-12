package com.onetoone.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onetoone.entity.AadharCard;

public interface AadharRepo extends JpaRepository<AadharCard, Integer>{

}
