package com.techproed.testBaseClasses;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.response.Response;

import com.techproed.testBaseClasses.TestBaseHerokuApp;


public class GetRequest06 extends TestBaseHerokuApp {
	 /*
	  * When 
	  		I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking/5 
	  Then 
		  HTTP Status Code should be 200
		  And response content type is “application/JSON” 
		  And response body should be like; 
		  { 
		  	"firstname": "Sally", 
		    "lastname": "Ericsson", 
		    "totalprice": 111,
		    "depositpaid": false, 
		    "bookingdates": { "checkin": "2017-05-23", 
		                      "checkout":"2019-07-02" }
		  }*/
	
	@Test
	public void get01()
	{
		//set the URL
		spec.
		pathParam("bookingName", "booking").
		queryParams("firstname", "Sally", 
				    "lastname", "Ericsson");

		
		
		//set the expected data
		
		
		//send the request
		Response response= given().spec(spec).when().get("/{bookingName}");
		
		response.prettyPrint();
		
		
		//Assert
		response.then().assertThat().statusCode(200);
		
		assertTrue(response.asString().contains("bookingid"));
	}


}
