package com.app.tests;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.with;

import java.net.URI;
import java.net.URISyntaxException;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response; 

public class APITest1 {

	/*
	 * When I send a GET request to REST Url https://api.github.com/users/Tairovich
	   Then response status should be 200
	 */
	String url = "https://api.github.com/users/Tairovich";
	@Test
	public void basicTestWithGet() {
		
		//BDD format: when the user goes to that url, then status code should be 200
		when().get(url)
			.then().statusCode(200);
	}
	
	/*
	 * When I send a GET request to REST Url https://api.github.com/users/Tairovich
	 	Then I should see JSON Response
	 */
	@Test
	public void printResponse() {
		when().get(url)
			.body().prettyPrint();
	}
	
	  /*
	   * When I send a GET request to REST Api Url
		https://api.github.com/users/Tairovich
		And Accept type is "application/json"
		Then response status code should be 200
	   */
	@Test
	public void getWithHeaders() {
		with().accept(ContentType.JSON)
			.when().get(url)
			.then().statusCode(200);
	}
	  /*
	   * When I send a GET request to REST URL:
	   		https://api.github.com/users/Tairovich
	   * Then status code is 404
	   * And Response body error message is "Not Found"
	   */
	@Test
	public void negativeGet() {
//		when().get(url+"hh")
//			.then().statusCode(404);
		Response response = when().get(url+"hh");
		Assert.assertEquals(response.statusCode(),404);
		Assert.assertTrue(response.asString().contains("Not Found"));
		response.prettyPrint();
		
	}
	
	  /*  
	   * When I send a GET request to REST URL:
	   		https://api.github.com/users/Tairovich
	   * And Accept type is json
	   * Then status code is 200
	   * And Response content should be json
	   * 
	   * WITH,WHEN,GET,ASSERTTHAT,ACCEPT,CONTENTTYPE
	   */
	
	@Test
	public void verifyContentTypeWithAssertThat() {
		given().accept(ContentType.JSON)
			.when().get(url)
			.then().assertThat().statusCode(200)
			.and().assertThat().contentType(ContentType.XML);
	}
	
	  /*Given Accept type is JSON
	   * When I send a GET request to REST URL:
	   * http://34.223.219.142:1212/ords/hr/employees/100
	   * Then status code is 200
	   * And Response content should be json
	   * And login should be "Tairovich"
	   * And id should be 38773866 
	   */
	
	@Test
	public void verifyFirstName() throws URISyntaxException {
		URI uri = new URI(url);
		
		given().accept(ContentType.JSON)
			.when().get(url)
			.then().assertThat().statusCode(200)
			.and().assertThat().contentType(ContentType.JSON)
			.and().assertThat().body("login", Matchers.equalTo("Tairovich"))
			.and().assertThat().body("id", Matchers.equalTo(38773866));
	}
}
