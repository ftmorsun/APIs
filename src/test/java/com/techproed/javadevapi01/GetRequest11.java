package com.techproed.javadevapi01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.sun.xml.xsom.impl.scd.Iterators.Map;

import io.restassured.response.Response;
import com.techproed.testBaseClasses.*;

public class GetRequest11 extends TestBaseDummy {
	/*
	 	When
	 		I send GET Request to the Url http://dummy.restapiexample.com/api/v1/employees
	 	Then
	 		Status code is 200
	 		And 5th employee name is Airi Satou
	 		And the number of employees is 24
	 		And the salary of 2nd last employee is 106450
	 		And 40, 21, and 19 are among the ages
	 		And 11th employee is like {
							            "id": "11",
							            "employee_name": "Jena Gaines",
							            "employee_salary": "90560",
							            "employee_age": "30",
							            "profile_image": ""
        							   }
	 */
	
	@Test
	public void get01() {
		//Set the URL
		spec.pathParams("api", "api", 
				        "version", "v1",
				        "employees", "employees");
		
		//Set the expected data
		
		HashMap<Object, Object> expectedData = new HashMap<>();
		expectedData.put("statusCode", 200);
		expectedData.put("fifthEmployee", "Airi S0atou");
		expectedData.put("numOfEmployee", "24");
		expectedData.put("secondSalary", "106450");
		
		List<String> ageList = new ArrayList<>();
		ageList.add("40");
		ageList.add("21");
		ageList.add("19");
		
		expectedData.put("ages", ageList);
		
		HashMap<Object, Object> innerMap = new HashMap<>();
		innerMap.put("id", "11");
		innerMap.put("employee_name", "Jena Gaines");
		innerMap.put("employee_salary", "90560");
		innerMap.put("employee_age", "30");
		innerMap.put("profile_image", "");
		
		expectedData.put("eleventhEmployee", innerMap);
		
		System.out.println(expectedData);
		
		//Send the request
		Response response = given().spec(spec).when().get("/{api}/{version}/{employees}");
		
		response.prettyPrint();
		
		//Assertion
		HashMap<String, Object> actualData = response.as(HashMap.class);
		System.out.println(actualData);
		
		assertEquals(expectedData.get("statusCode"), response.getStatusCode());
			
	}

}
