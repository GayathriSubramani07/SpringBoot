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
		
		List<Student> list=service.getStudent();
		System.out.println(list);
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
	
	 private StudentRepo repo; 
	

	public StudentRepo getRepo() {
		return repo;
	}

	@Autowired 
	public void setRepo(StudentRepo repo) {
		this.repo = repo;
	}


	public void addStudent(Student s) {
		repo.save(s);
		
	}

	public List<Student> getStudent() {
		// TODO Auto-generated method stub
		return repo.findAll();
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
	private JdbcTemplate jdbc;
	
	

	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	@Autowired
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public void save(Student s) {
		String sql="insert into student(rollno,name,marks) values(?,?,?)";
		int rows=jdbc.update(sql,s.getRollNo(),s.getName(),s.getMarks());
		System.out.println(rows +" affected");
		
		
	}

	public List<Student> findAll() {
		String sql="select * from student"; 
		
		RowMapper<Student> mapper = new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s=new Student();
				s.setRollNo(rs.getInt("rollno"));
				s.setName(rs.getString("name"));
				s.setMarks(rs.getInt("marks"));

				return s;
			}
		};
		return jdbc.query(sql,mapper);  
	}

}
