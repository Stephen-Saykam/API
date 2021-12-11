package crudOperations_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateTest {
	
	
	@Test
	public void createTest()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "steef");
		jobj.put("projectName", "TYSS25");
		jobj.put("status", "On Going");
		jobj.put("teamSize", 10);
		
		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jobj);
		
		Response res = reqspec.post("http://localhost:8084/addProject");
		ValidatableResponse valres = res.then();
		valres.assertThat().statusCode(201);
		valres.log().all();
	}

}
