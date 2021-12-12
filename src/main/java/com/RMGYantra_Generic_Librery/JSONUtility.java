package com.RMGYantra_Generic_Librery;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JSONUtility {
	
	@Test
	public String jsonPathFinder(String jsonpath, Response resp)
	{
		String text = resp.jsonPath().getString(jsonpath);
		return text;
	}

}
