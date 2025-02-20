//FirstbootApplication.java
package com.example.Firstboot;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstbootApplication {

	public static void main(String[] args) {
		
		ApplicationContext context=SpringApplication.run(FirstbootApplication.class, args);
		Alien obj=context.getBean(Alien.class);
		
		
		obj.code();
		
	}                                                        

}



//Alien.java
package com.example.Firstboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Alien {


    public void code() {
        
        System.out.println("Coding");
    }
}
