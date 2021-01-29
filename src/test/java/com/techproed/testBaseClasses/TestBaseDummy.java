package com.techproed.testBaseClasses;




import java.util.HashMap;

import org.junit.Before;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class TestBaseDummy {
	
	protected RequestSpecification spec;
	
	@Before
	public void setUp() {	
		spec = new RequestSpecBuilder().
							setBaseUri("http://dummy.restapiexample.com").
							build();	
	}

	public HashMap<String, Object> setUpData() {
		// TODO Auto-generated method stub
		return null;
	}

}