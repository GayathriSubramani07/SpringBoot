package com.velox.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.velox.springboot.SpringbootApplication;
import com.velox.springboot.dao.UserDao;
import com.velox.springboot.entity.Employee;
import com.velox.springboot.entity.User;
import com.velox.springboot.repo.EmployeeRepo;
import com.velox.springboot.utile.ResponseStructure;

@Service
public class UserService {

    private final SpringbootApplication springbootApplication;
	
	@Autowired
	private UserDao userDao;

    UserService(SpringbootApplication springbootApplication) {
        this.springbootApplication = springbootApplication;
    }

	public ResponseStructure<User> saveUser(User user) {
		User dbuser= userDao.saveUser(user);
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("Data saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setObj(dbuser);
		return structure;
		
	}

	public ResponseStructure<List<User>> getUser() {
		
		List<User> dbuser=  userDao.getUser();
		ResponseStructure<List<User>> structure =new ResponseStructure<>();
		structure.setMessage("Data fetched successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setObj(dbuser);
		return structure;
		
		
	}

	public ResponseEntity<ResponseStructure<User>> getUserById(int id) {
		// TODO Auto-generated method stub
		User dbUser= userDao.getUserById(id);
		if(dbUser !=null)
		{
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setMessage("Data fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setObj(dbUser);
			return new ResponseEntity<>(structure,HttpStatus.FOUND);
		}
		else
		{
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setMessage("Data is not found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setObj(dbUser);
			return new ResponseEntity<>(structure,HttpStatus.NOT_FOUND);
		}
	}

	

	public ResponseStructure<User> updateUserById(User user, int userId) {
		// TODO Auto-generated method stub
		User use= userDao.updateUserById(user,userId);
		if(use !=null) {
			ResponseStructure<User> structur=new ResponseStructure<>();
			structur.setMessage("Data updated Successfully");
			structur.setStatus(HttpStatus.FOUND.value());
			structur.setObj(use);
			return structur;
			
		}
		else {
			ResponseStructure<User> structure =new ResponseStructure<>();
			structure.setMessage("Data is not founnd");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setObj(use);
			return structure;
		}
	}

	public ResponseEntity<String> deleteUserById(int id) {
		// TODO Auto-generated method stub
		User dbuser= userDao.deleteUserById(id);
		if (dbuser != null) {
		    return new ResponseEntity<>("Data deleted successfully", HttpStatus.FOUND);
		} else {
		    return new ResponseEntity<>("Data not found", HttpStatus.NOT_FOUND);
		}

	}

	public void deleteAll() {
		
		 userDao.deleteAll();
	}

	public Employee getByName(String name) {
		// TODO Auto-generated method stub
		return userDao.getByName(name);
	}
	
	public Employee fetchAddress(String address) {
		// TODO Auto-generated method stub
		return userDao.fetchAddress(address);
	}

	

}
