package com.app.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.app.utilities.ConfigurationReader;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APIDay3JsonPath {

	/*
	 * GIven accept type is json
	 * When I send a GET request to REST url
	 * 
	 * then the status code is 200
	 * response content should be json
	 * 
	 */
	
	@Test
	public void testItemsCountFromREsponseBody() {
		given().accept(ContentType.JSON).
		when().get(ConfigurationReader.getProperty("git.url"))
		.then().assertThat().statusCode(200)
		.and().assertThat().contentType(ContentType.JSON)
		.and().body("$",hasSize(46));
		
		
	}
}
