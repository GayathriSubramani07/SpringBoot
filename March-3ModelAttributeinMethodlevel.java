//SpringBoodWeb1Application.java

package com.example.SpringBoodWeb1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoodWeb1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoodWeb1Application.class, args);
		
	}

}
 

//HomeController.java
package com.example.SpringBoodWeb1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	
	@RequestMapping("addclient")
	public String addclient(@ModelAttribute("c") Client c) {
		return "result";
	}
	

	@ModelAttribute("course")
	public String courseName()
	{
		return "C";
	}

}
 





//result.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Addition Form</title>
   
</head>
<body>
    <div class="container">
      
        <p>Welcome to the ${course} course</p>
        
    </div>
</body>
</html>



 
