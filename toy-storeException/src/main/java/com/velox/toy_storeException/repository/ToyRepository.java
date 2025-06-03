package com.velox.toy_storeException.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.velox.toy_storeException.model.Toy;

public interface ToyRepository extends JpaRepository<Toy, Integer> {

}
