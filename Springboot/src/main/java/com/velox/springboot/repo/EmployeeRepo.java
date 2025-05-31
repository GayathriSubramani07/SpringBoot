package com.velox.springboot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.velox.springboot.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	Optional<Employee> getByName(String name);
	@Query("SELECT e FROM Employee e WHERE e.address = :address")
	Optional<Employee> fetchAddress(@Param("address") String address);


}
