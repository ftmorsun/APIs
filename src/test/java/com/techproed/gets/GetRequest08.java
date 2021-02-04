package com.techproed.gets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import com.techproed.*;
import com.techproed.testbaseclasses.TestBaseDummy;

public class GetRequest08 extends TestBaseDummy{

/*When 
	 		I send Get Request to http://dummy.restapiexample.com/api/v1/employees
	 	Then
	 		The Status code is 200
	 		And The name of 3rd employee is "Ashton Cox"
	 		And The Salary of 6th employee is 372000
	 		And The age of the last employee is 23
	 		And 21, 23, 61 are among the ages
*/
	
	
	@Test
	public void get01()
	{
		//Set the URL
				spec.pathParams("api", "api", 
						        "version", "v1",
						        "employees", "employees");
		//Set the expected values
				
		//Send the Request
		Response response = given().spec(spec).when().get("/{api}/{version}/{employees}");
				
		response.prettyPrint();
		
JsonPath json = response.jsonPath();
		
		assertEquals(200, response.getStatusCode());
		
		//The name of 3rd employee is "Ashton Cox"
		assertEquals("Ashton Cox", json.getString("data[2].employee_name"));
		
		//The Salary of 6th employee is 372000
		assertEquals("372000", json.getString("data[5].employee_salary"));
		
		//The age of the last employee is 23
		assertEquals("23", json.getString("data[-1].employee_age"));
		
		//The age of the second last employee is 21
		assertEquals("21", json.getString("data[-2].employee_age"));
		
		//21, 23, 61 are among the ages
		List<String> ageList = new ArrayList<>();
		ageList.add("21");
		ageList.add("23");
		ageList.add("61");

		assertTrue(json.getList("data.employee_age").containsAll(ageList));
				
				
	}

}
