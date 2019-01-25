package com.app.tests;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class RestTest {

	
	@BeforeClass
	public void setUp() {
		//these will apply to all tests
		RestAssured.baseURI = "https://www.batch8-api-site.dev.cc/wp-json";
		RestAssured.basePath = "/wp/v2";
	}
	
	//Given rest end point https://postman-echo.com/time/leap?timestamp=2016-10-10
	//When I send an HTTP request to the server
	//then I should get 200 ok status
	String uri ="https://postman-echo.com/time/leap?timestamp=2016-10-10";
	
	@Test
	public void firstTest() {
		when()
			.get(uri)
		.then()
			.statusCode(200);
	}
	
	/*
	 * Given rest end point https://www.batch8-api-site.dev.cc/wp-json/wp/v2/posts/
	 * When I send the request to the server
	 * Then I should get 200 ok status code
	 */
	
	@Test
	public void secondTest() {
	
		given().relaxedHTTPSValidation()
		.when()
			.get("https://www.batch8-api-site.dev.cc/wp-json/wp/v2/posts/1")
		.then()
			.statusCode(200);
	}
	/*
	 * Given rest end point 
	 * 		https://www.batch8-api-site.dev.cc/wp-json/wp/v2/posts/1
	 * When I send the request to the server
	 * Then I should get 200 ok status code
	 * and id value should also be 1
	 */
	
	@Test
	public void idTest() {
		given().relaxedHTTPSValidation()
		.when()
			.get("https://www.batch8-api-site.dev.cc/wp-json/wp/v2/posts/1")
		.then()
			.assertThat().statusCode(200)
		.and()
			.assertThat().body("id", equalTo(1))
		.and()
			.assertThat().body("title.rendered", equalTo("Bye World"));
	}
	
	
	@Test
	public void idTest_withLogDetail() {
		given().relaxedHTTPSValidation()
		.when()
			.log().all()
			.get("https://www.batch8-api-site.dev.cc/wp-json/wp/v2/posts/1")
		.then()
			.log().all()
			.assertThat().statusCode(200)
		.and()
			.assertThat().body("id", equalTo(1))
		.and()
			.assertThat().body("title.rendered", equalTo("Bye World"));
	}
	 
	
	@Test
	public void testStatusAndPost() {
		given().relaxedHTTPSValidation()
		.when()
			.log().all()
			.get("https://www.batch8-api-site.dev.cc/wp-json/wp/v2/posts/{id}",1)
		.then()
			.log().all()
			.assertThat().statusCode(200)
		.and()
			.assertThat().body("status", equalTo("publish"))
		.and()
			.assertThat().body("type", equalTo("post"));
	}
	
	
	@Test
	public void four_Test() {
		//in get() just insert / and your path
		
		given().relaxedHTTPSValidation()
		.when()
			.get("/posts")
		.then()
			.statusCode(200);
	}
	
	
	@Test
	public void testWithHamcrest() {
		
		int a = 5, b = 5, c = 6;
		
	//	assertThat(a, equalTo(c));
		
	}
	
	
	
	
	
	
	
	
	
}
