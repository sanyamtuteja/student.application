package com.students.base;

import org.testng.annotations.BeforeClass;

import com.jayway.restassured.RestAssured;

public class TestBase {
	@BeforeClass
	public static void init() {
		
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/student";
	}
}
