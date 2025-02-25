//FirstbootApplication.java

package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.model.Laptop;
import com.example.service.LaptopService;

@SpringBootApplication
public class FirstbootApplication {

	public static void main(String[] args) {
		
		ApplicationContext context=SpringApplication.run(FirstbootApplication.class, args);
		LaptopService service=context.getBean(LaptopService.class);
		Laptop lap=context.getBean(Laptop.class);
		service.addLaptop(lap);
		
	}                                                         

}

//LaptopService.java

package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Laptop;
import com.example.repository.LaptopRepository;
@Service
public class LaptopService {
	
	@Autowired
	private LaptopRepository repo;

	public void addLaptop(Laptop lap) {
		
		repo.save(lap);
	}
	
	public boolean isGoodorProg(Laptop lap)
	{
		return true;
	}

}

//LaptopRepository.java
package com.example.repository;

import org.springframework.stereotype.Repository;

import com.example.model.Laptop;

@Repository
public class LaptopRepository {
	


	public void save(Laptop lap) {
		System.out.println("Method calling in repo");
		
	}

}
