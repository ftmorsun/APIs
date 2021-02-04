package com.techproed.gets;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequest01 {
	/*
	 * Gherkin Language
	 * Given: It declares prerequisites
	 * When: It defines the action which user will perform
	 * Then: It gives output what would be output
	 * And:
	 */
	protected int value;
	@Test
	public void get01()
	{
		//1.Step: Set the URL
				String url = "https://restful-booker.herokuapp.com/booking/3";
				
				//2.Step: Set the expected data
				
				//3.Step: Send the request to the API 
				Response response = given().accept("application/json").when().get(url); //ContentType.JSON also works
				
				response.prettyPrint();
				
				//4.Step: Make assertions
				response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");
				
	}



}
