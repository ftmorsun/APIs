package com.techproed.testBaseClasses;

import org.junit.Before;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class TestBaseHerokuApp {
	
	protected RequestSpecification spec;
	
	@Before
	public void setUp() {	
		spec = new RequestSpecBuilder().
							setBaseUri("https://restful-booker.herokuapp.com").
							build();	
	}

}
