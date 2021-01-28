package com.techproed.javadevapi01;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequest02 {
	
	/*
	 * When
	  	I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/1001
	  Then
		 HTTP Status code should be 404
	  And
		 Status Line should be HTTP/1.1 404 Not Found
	  And
	     Response body contains "Not Found"
	  And
	     Response body does not contain "TechProEd"*/
	
	@Test
	public void get02()
	{
		      //1.Step: Set the URL
		       
		        SoftAssert softAssert= new SoftAssert();

				String url = "https://restful-booker.herokuapp.com/booking/1001";
				
				//2.Step: Set the expected data
				
				//3.Step: Send the request to the API 
				Response response = given().accept(ContentType.JSON).when().get(url); //ContentType.JSON also works
				
				response.prettyPrint();
				
				//Below Fails due to above failure of status code
				//assertTrue(response.asString().contentEquals("Not Found"));
				//assertFalse(response.asString().contentEquals("TechProed"));
				
				//4.Step: Make assertions
				response.then().assertThat().statusCode(404).and().statusLine("HTTP/1.1 404 Not Found");
				
				softAssert.assertTrue(response.asString().contentEquals("Not found"));
				System.out.println("Failed");
				softAssert.assertFalse(response.asString().contentEquals("TechProed"));
				System.out.println("Wow");
			     softAssert.assertAll();
	}


}
