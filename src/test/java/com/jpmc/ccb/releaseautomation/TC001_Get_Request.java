package com.jpmc.ccb.releaseautomation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_Get_Request {

	@Test
	public void getWeatherDetails(){
		
		//Specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		//Request object created
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/Hyderabad");
		
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		System.out.println(statuscode);
		System.out.println(response.getBody().asString());
		
		//status line verification
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "Http/1.1 200 OK");
		
		
	}
}
