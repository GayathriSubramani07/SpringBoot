//SpringJdbcApplication.java
package com.example.SpringJDBC;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.model.Student;
import com.example.service.StudentService;

@SpringBootApplication(scanBasePackages = "com.example")

public class SpringJdbcApplication {

	public static void main(String[] args) {
	ApplicationContext context=	SpringApplication.run(SpringJdbcApplication.class, args);
		 
		Student s=context.getBean(Student.class); 
		s.setRollNo(1);
		s.setName("gayu");
		s.setMarks(1000);
		StudentService service=context.getBean(StudentService.class);
		service.addStudent(s);
		
	}

}


  //Student.java

package com.example.model;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")

public class Student {
	
	private int rollNo;
	
	private String name;
	
	private int marks;

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", marks=" + marks + "]";
	}
	
	
	
	

}


//StudentService.java

package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.StudentRepo;
import com.example.model.Student;

@Service
public class StudentService {
	@Autowired
	 private StudentRepo repo; 
	
  public void addStudent(Student s) {
		repo.save(s);
		
	}


}

//StudentRepo.java

package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.model.Student;

@Repository
public class StudentRepo {
	@Autowired
	private JdbcTemplate jdbc;
	
	public void save(Student s) {
		String sql="insert into student(rollno,name,marks) values(?,?,?)";
		int rows=jdbc.update(sql,s.getRollNo(),s.getName(),s.getMarks());
		System.out.println(rows +" affected");
		
		
	}

}

//data.sql
INSERT INTO student(rollno, NAME, marks) VALUES (101, 'janani', 90);
INSERT INTO student(rollno, NAME, marks) VALUES (102, 'Ammu', 99);
INSERT INTO student(rollno, NAME, marks) VALUES (103, 'sri', 95);

//schema.sql
CREATE TABLE student(
rollno INT PRIMARY KEY,
name VARCHAR(20),
marks INT
);


