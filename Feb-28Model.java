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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		System.out.println("Hello");
		return "index.jsp";
	}
	
	@RequestMapping("add")
	public String add(@RequestParam("num1") int  num,@RequestParam("num2")int n , Model model) {
		
		int result=num+n;
		model.addAttribute("result", result);
			System.out.println(result);
		 
		
		return "result.jsp";
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
        <h2>Result is:   <%=session.getAttribute("result")%></h2>

	//if i created a jsp file inside the /WEB-INF/views/ i need to use this line  <h2>Result is:${result}</h2>


        
    </div>
</body>
</html>


/*Why session.getAttribute("result") Works Without Explicit HttpSession Usage
Even though you are not explicitly using HttpSession in your controller, Spring automatically stores Model attributes in the request scope.

In JSP, there is a special mechanism:

If a variable is not found in the session scope, JSP automatically searches in the request scope.
Since Model stores data in the request scope, JSP can still retrieve it.
What’s Happening Behind the Scenes?
In the controller, you set model.addAttribute("result", result);, which stores result in the request scope.
When JSP tries to access session.getAttribute("result"), it does not find it in the session scope.
JSP then checks the request scope (where Model stores data).
It finds result in the request scope and prints it.*/
