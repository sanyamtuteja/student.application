package com.students.logging;

import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class LoggingResponseValues {

	
	@Test
	public void test001() {
		System.out.println("-------Printing Response Headers--------");
		given()
		.param("programme","Computer Science")
		.param("limit",1)
		.when()
		.get("/list")
		.then()
		.log()
		.headers()
		.statusCode(200);
}
	@Test
	public void test002() {
		System.out.println("-------Printing Response Status Line--------");
		given()
		.param("programme","Computer Science")
		.param("limit",1)
		.when()
		.get("/list")
		.then()
		.log()
		.status()
		.statusCode(200);
}
	
	
	@Test
	public void test003() {
		System.out.println("-------Printing Response Body--------");
		given()
		.param("programme","Computer Science")
		.param("limit",1)
		.when()
		.get("/list")
		.then()
		.log()
		.body()
		.statusCode(200);
}
	
	@Test
	public void test004() {
		System.out.println("-------Printing Response incase of error--------");
		given()
		.param("programme","Computer Science")
		.param("limit",-1) // error here
		.when()
		.get("/list")
		.then()
		.log()
		.ifError();
}
}
