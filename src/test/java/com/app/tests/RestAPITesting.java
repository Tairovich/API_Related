package com.app.tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class RestAPITesting {

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "https://www.batch8-api-site.dev.cc/wp-json";
		RestAssured.basePath = "/wp/v2";
	}

	@Test
	public void simpleGetRequest() {
		given().
			relaxedHTTPSValidation().when()
			.log().all().
		//	queryParam("per_page", 2).
			pathParam("id", 22).
			get("/posts/{id}") //or get("/posts/{id}",22)
		.then().
			log().all()
		.assertThat().
			statusCode(200)
		.and()
			.body("id", equalTo(22))

			.body("title.rendered", is("API Day 3 Post"))
			.body("sticky", is(false));
	}

	@Test
	public void printBody() {
		given()
			.relaxedHTTPSValidation()
		.when()
			.log().all()
		.get("/posts")
			.body().prettyPrint();
	}
}
