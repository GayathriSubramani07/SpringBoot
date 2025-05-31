package com.velox.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.velox.springboot.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
