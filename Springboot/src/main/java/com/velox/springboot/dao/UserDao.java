package com.velox.springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.velox.springboot.entity.Employee;
import com.velox.springboot.entity.User;
import com.velox.springboot.repo.EmployeeRepo;
import com.velox.springboot.repo.UserRepo;

@Repository
public class UserDao  {
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private EmployeeRepo emprepo;

	public User saveUser(User user) {
		return repo.save(user);
	
		
	}

	public List<User> getUser() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	

	public User getUserById(int id) {
	    return repo.findById(id).orElse(null); 
	}
	
	

	public User updateUserById(User user, int userId) {
		// TODO Auto-generated method stub
		Optional<User> optional=repo.findById(userId);
		if(optional.isPresent()) {
			System.out.println(user.getId());
			user.setId(userId);
			System.out.println(user.getId());
			return repo.save(user);
		}
		else {
			return null;
		}
		
	}

	public User deleteUserById(int id) {
		Optional<User> optional=repo.findById(id);
		if(optional.isEmpty())
		{
			return null;
		}
		else {
			User user=optional.get();
			 repo.deleteById(id);
			 return user;
		}
		
		
	}

	public void deleteAll() {
		
		 repo.deleteAll();
	}

	public Employee getByName(String name) {
	    Optional<Employee> optional = emprepo.getByName(name);
	    
	    if (optional.isPresent()) {
	        Employee us=optional.get();
	        return us;
	    } else {
	        return null;
	    }
	}

	public Employee fetchAddress(String address) {
		Optional<Employee> optional=emprepo.fetchAddress(address);
		if(optional.isPresent()) {
			Employee e=optional.get();
			return e;
		}
		else
		{
			return null;
		}
	}

	
	
	
 
}
