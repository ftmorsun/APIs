package com.techproed.gets;

import static org.junit.Assert.assertEquals;
import static io.restassured.RestAssured.given;
import org.junit.Test;

import com.techproed.pojos.Bookingdate;
import com.techproed.pojos.Bookings;
import com.techproed.testbaseclasses.TestBaseHerokuApp;

import io.restassured.response.Response;

public class GetRequest13 extends TestBaseHerokuApp {
	/*
	 	When 
	 		I send GET Request to https://restful-booker.herokuapp.com/booking/1
	 	Then 
	 		Response body should be like that;
	 		{
			    "firstname": "Eric",
			    "lastname": "Smith",
			    "totalprice": 555,
			    "depositpaid": false,
			    "bookingdates": {
			        "checkin": "2016-09-09",
			        "checkout": "2017-09-21"
			     }
			}
	 */
	
	@Test
	public void get01() {
		
		spec.pathParams("booking", "booking",
				        "id", 1);
		
		Bookingdate bookingdates = new Bookingdate("2018-06-21", "2018-12-09");
		Bookings expectedData = new Bookings("Susan", "Jones", 883, true, bookingdates);
		
		System.out.println(expectedData);
		
		Response response = given().spec(spec).when().get("/{booking}/{id}");
		response.prettyPrint();
		
		Bookings actualData = response.as(Bookings.class);
		System.out.println(actualData);
		
//		assertEquals(expectedData.getFirstname(), actualData.getFirstname());
//		assertEquals(expectedData.getLastname(), actualData.getLastname());
//		assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
//		assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());
		
		assertEquals(expectedData.getBookingdate().getCheckin(), actualData.getBookingdate().getCheckin());
		assertEquals(expectedData.getBookingdate().getCheckout(), actualData.getBookingdate().getCheckout());

	}
}
