package com.students.logging;

import com.jayway.restassured.http.ContentType;
import com.student.model.Student;
import com.students.base.TestBase;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.testng.annotations.Test;


public class LoggingRequestValues extends TestBase{
	/**
	 * This test will print out all the request headers
	 * 	
	*/
	@Test
	public void test001() {
		System.out.println("-------Printing request headers--------");
		given()
		.log()
		.headers()
		.when()
		.get("/1")
		.then()
		.statusCode(200);
		
	}

	@Test
	public void test002() {
		System.out.println("-------Printing request parameters--------");
		given()
		.param("programme","Computer Science")
		.param("limit",1)
		.log()
		.params()
		.when()
		.get("/list")
		.then()
		.statusCode(200);
}
	
	
	@Test
	public void test003() {
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("C++");
		System.out.println("-------Printing request Body--------");

		Student student = new Student();
		
		
		student.setFirstname("Sanyam");
		student.setLastname("Tuteja");
		student.setEmail("abc@xyz.com");
		student.setProgramme("Computer");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.log()
		.body()
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
}
	
	@Test
	public void test004() {
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("C++");
		System.out.println("-------Printing all the request details--------");

		Student student = new Student();
		
		
		student.setFirstname("Sanyam");
		student.setLastname("Tuteja");
		student.setEmail("abc@xyz.com");
		student.setProgramme("Computer");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.when()
		.body(student)
		.post();
		
}
	
	
	@Test
	public void test005() {
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("C++");
		System.out.println("-------Printing all the request details when validation fails--------");

		Student student = new Student();
		
		
		student.setFirstname("Sanyam");
		student.setLastname("Tuteja");
		student.setEmail("abc@xyz.com");
		student.setProgramme("Computer");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.log()
		.ifValidationFails()
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
}
	
	
	
}