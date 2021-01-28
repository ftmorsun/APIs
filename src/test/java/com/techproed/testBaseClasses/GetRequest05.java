package com.techproed.testBaseClasses;
import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class GetRequest05 extends TestBaseJsonPlaceHolder {
	
	@Test
	public void get01()
	{
		//Set the url
		spec.pathParams("todoName", "todos", 
						"id", 123);
		
		//Set the expected data
		
		//Send the request
		Response response = given().accept(ContentType.JSON).spec(spec).when().get("/{todoName}/{id}");
	    response.prettyPeek();
		
	    
	    response.then().
	    		assertThat().
	    		statusCode(200).
	    		header("Server", "cloudflare");
	    		
		
	}

}
