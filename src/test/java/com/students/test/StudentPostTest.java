package com.students.test;

import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.student.model.Student;
import com.students.base.TestBase;

import static com.jayway.restassured.RestAssured.*;


public class StudentPostTest extends TestBase {
	
	
	
	@Test
	public void createNewStudent() {
		
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("C++");
		
		Student student = new Student();
		
		
		student.setFirstname("Sanyam");
		student.setLastname("Tuteja");
		student.setEmail("abc@xyz.com");
		student.setProgramme("Computer");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
		
		

	}

}
