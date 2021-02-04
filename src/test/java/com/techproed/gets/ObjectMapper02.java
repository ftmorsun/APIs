package com.techproed.gets;

import java.util.HashMap;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import io.restassured.response.Response;
import com.techproed.testbaseclasses.*;
import utilities.JsonUtil;

public class ObjectMapper02 extends TestBaseHerokuApp{
	
	/*
	 	When 
	 		I send GET Request to the URL https://restful-booker.herokuapp.com/booking/2
	 		
	 	Then 
	 		Status code is 200
	 		And response body is like {
									    "firstname": "Mark",
									    "lastname": "Ericsson",
									    "totalprice": 726,
									    "depositpaid": true,
									    "bookingdates": {
									        "checkin": "2015-08-07",
									        "checkout": "2020-10-25"
									     }
									  }
	*/
	
	@Test
	public void get01() {
		//Set the URL
		spec.pathParams("booking", "booking",
				        "id", 2);
		
		//Set the expected data
		String expectedJson = "{\n"
							+ "\"firstname\": \"Eric\",\n"
							+ "\"lastname\": \"Ericsson\",\n"
							+ "\"totalprice\": 534,\n"
							+ "\"depositpaid\": true,\n"
							+ "\"bookingdates\": {\n"
							+ "\"checkin\": \"2017-08-08\",\n"
							+ "\"checkout\": \"2020-06-28\"\n"
							+ "}\n"
							+ "}";
		HashMap<String, Object> expectedData = JsonUtil.convertJsonToJava(expectedJson, HashMap.class);
		
		//Send the request
		Response response = given().spec(spec).when().get("/{booking}/{id}");
		HashMap<String, Object> actualData = JsonUtil.convertJsonToJava(response.asString(), HashMap.class);
		
		//Assertions
//		assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
//		assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
//		assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
//		assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
		assertEquals(expectedData.get("bookingdates"), actualData.get("bookingdates"));
		
		assertEquals(((HashMap)expectedData.get("bookingdates")).get("checkin"), ((HashMap)actualData.get("bookingdates")).get("checkin"));
		assertEquals(((HashMap)expectedData.get("bookingdates")).get("checkout"), ((HashMap)actualData.get("bookingdates")).get("checkout"));
		
		
		//Convert actualData HashMap to Json data
		String jsonFromJava = JsonUtil.convertJavaToJson(actualData);
		System.out.println(jsonFromJava);

	}

}