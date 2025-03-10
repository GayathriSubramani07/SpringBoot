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
	@RequestMapping("/")
	public String home() {
		System.out.println("Hello");
		return "index";
	}
	
	@RequestMapping("addclient")
	public String addclient(@ModelAttribute("c") Client c) {
		return "result";
	}

}


//index.jsp

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Addition Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 40%;
            background: white;
            margin: 50px auto;
            padding: 20px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        h2 {
            color: #333;
        }

        form {
            margin-top: 20px;
        }

        input[type="text"] {
            width: 80%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background: #28a745;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            font-size: 16px;
            border-radius: 5px;
        }

        input[type="submit"]:hover {
            background: #218838;
        }

        .result {
            font-size: 18px;
            color: #007bff;
            font-weight: bold;
        }

        a {
            display: inline-block;
            margin-top: 15px;
            text-decoration: none;
            color: white;
            background: #007bff;
            padding: 10px 15px;
            border-radius: 5px;
        }

        a:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Enter Data</h2>
        <form action="addclient" method="post">
            Id: <input type="text" name="id" id="id"required><br><br>
          Name: <input type="text" name="name" id="name" required><br><br>
            <input type="submit" value="submit">
        </form>
    </div>
</body>
</html>



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
        <h2>Welcome ${c} </h2>
        
    </div>
</body>
</html>


  //Client.java

  package com.example.SpringBoodWeb1;

public class Client {
	private int id;
	
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + "]";
	}
	
	

}

    
