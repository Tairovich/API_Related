package com.app.tests;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIBasicTestsReview {

	String url = "https://api.github.com/users/Tairovich";

	// verify that status code is 200
	@Test
	public void basicTest() {
		when().get(url).then().assertThat().statusCode(200);
		System.out.println("working");
	}

	// print body
	@Test
	public void printRequestBody() {
		given().get(url).body().prettyPrint();
	}
	/*
	 * When I send a GET request to REST Api Url "application/json" Then response
	 * status code should be 200
	 */

	@Test
	public void getWithHeaders() {
		given().accept(ContentType.JSON).get(url).then().assertThat().statusCode(200);
	}
	/*
	 * When I send a GET request to REST URL:
	 * http://34.223.219.142:1212/ords/hr/employees/1234 Then status code is 404 And
	 * Response body error message is "Not Found"
	 */

	@Test
	public void negativeGet() {
		// given().get(url+"hh")
		// .then().assertThat().statusCode(404);
		//
		Response response = given().get(url + "hh");
		SoftAssert soft = new SoftAssert();

		soft.assertEquals(response.statusCode(), 202, "this is wrong");
		soft.assertTrue(response.asString().contains("Not Foundd"), "this is wrong");

		soft.assertAll();

	}

	/*
	 * When I send a GET request to REST URL:
	 * http://34.223.219.142:1212/ords/hr/employe
	 * status code is 200 And Response content should be json
	 * WITH,WHEN,GET,ASSERTTHAT,ACCEPT,CONTENTTYPE
	 */
	
	@Test
	public void verifyCOntentTYpeWithAssertThat() {
		given().accept(ContentType.JSON)
			.when().get(url)
			.then().assertThat().statusCode(200)
			.and().assertThat().contentType(ContentType.JSON);
	}
	 /*Given Accept type is JSON
	   * When I send a GET request to REST URL:
	   * http://34.223.219.142:1212/ords/hr/employees/100
	   * Then status code is 200
	   * And Response content should be json
	   * And first name should be "Steven
	   * And employee id is 100
	   */
	@Test
	public void verifyFirstName() {
		given().get(url)
		.then().assertThat().statusCode(200)
		.and().assertThat().contentType(ContentType.JSON)
		.and().assertThat().body("login", Matchers.equalTo("Tairovich"))
		.and().assertThat().body("id", Matchers.equalTo(38773866));
	}
}
