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
        <h2>Enter Two Numbers</h2>
        <form action="add" method="post">
            Number 1: <input type="text" name="num1" id="num1"required><br><br>
            Number 2: <input type="text" name="num2" id="num2" required><br><br>
            <input type="submit" value="Add">
        </form>
    </div>
</body>
</html>



      //HomeController.java

      package com.example.SpringBoodWeb1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		System.out.println("Hello");
		return "index.jsp";
	}
	
	@RequestMapping("add")
	public String add(HttpServletRequest req ,HttpSession session) {
		int num1=Integer.parseInt(req.getParameter("num1"));
		int num2=Integer.parseInt(req.getParameter("num2"));
		int result=num1+num2;
		session.setAttribute("result", result);
		System.out.println(result);
		
		
		return "result.jsp";
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
             <h2>Result is:   ${result} </h2>
        
    </div>
</body>
</html>

 
