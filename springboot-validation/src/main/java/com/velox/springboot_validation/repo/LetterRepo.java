package com.velox.springboot_validation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.velox.springboot_validation.entity.Letter;

public interface LetterRepo extends JpaRepository<Letter, String>{

}
