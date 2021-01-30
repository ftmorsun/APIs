package com.techproed.javadevapi01;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.techproed.testBaseClasses.TestBaseDummy;

import io.restassured.response.Response;

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
	
	@Test
	public void get02()
	{
		//Set the URL
		spec.pathParams("api", "api",
				        "version", "v1",
				        "employees", "employees");
		
		//Set the expected data
		TestBaseDummy obj = new TestBaseDummy();
		HashMap<String, Object> expectedData = obj.setUpData();
		
		System.out.println(expectedData);
		
		//Send Request
		Response response = given().spec(spec).when().get("/{api}/{version}/{employees}");
		response.prettyPrint();

		//Assert
		//1.Way: JsonPath Class + expectedData Map
//		JsonPath json = response.jsonPath();
//		
//		assertEquals(expectedData.get("statusCode"), response.getStatusCode());
//		assertEquals(expectedData.get("fifthEmpName"), json.getString("data[4].employee_name"));
//		assertEquals(expectedData.get("numOfEmployees"), json.getList("data").size());
//		assertEquals(expectedData.get("secondLastSalary"), json.getString("data[-2].employee_salary"));
//		assertTrue(json.getList("data.employee_age").containsAll((List)expectedData.get("ages")));
//		
//		assertTrue(json.getString("data[10].id").equals(((HashMap)expectedData.get("eleventhEmployee")).get("id")));
//		assertTrue(json.getString("data[10].employee_name").equals(((HashMap)expectedData.get("eleventhEmployee")).get("employee_name")));
//		assertTrue(json.getString("data[10].employee_salary").equals(((HashMap)expectedData.get("eleventhEmployee")).get("employee_salary")));
//		assertTrue(json.getString("data[10].employee_age").equals(((HashMap)expectedData.get("eleventhEmployee")).get("employee_age")));
//		assertTrue(json.getString("data[10].profile_image").equals(((HashMap)expectedData.get("eleventhEmployee")).get("profile_image")));
		
		//2.Way: GSON + expectedData Map
		HashMap<String, Object> actualData = response.as(HashMap.class);
		System.out.println(actualData);
		
//		assertEquals(expectedData.get("statusCode"), response.getStatusCode());
//		
//		assertEquals(expectedData.get("fifthEmpName"), ((HashMap)((List)actualData.get("data")).get(4)).get("employee_name"));
		
//		int size = ((List)actualData.get("data")).size();
//		assertEquals(expectedData.get("secondLastSalary"), ((HashMap)((List)actualData.get("data")).get(size-2)).get("employee_salary"));
//		assertEquals(expectedData.get("numOfEmployees"), ((List)actualData.get("data")).size());
		
		List<String> allAgesList = new ArrayList<>();
		
//		for(int i=0; i<((List)actualData.get("data")).size(); i++) {
//			allAgesList.add((String)((HashMap)((List)actualData.get("data")).get(i)).get("employee_age"));
//		}	
//		assertTrue(allAgesList.containsAll((List)expectedData.get("ages")));
		
		assertEquals(expectedData.get("eleventhEmployee"), ((List)actualData.get("data")).get(10));
	}

}
