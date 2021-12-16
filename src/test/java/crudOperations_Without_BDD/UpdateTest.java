package crudOperations_Without_BDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateTest {
	
	@Test
	public void updateTest()
	{
		//create an Object for random Class
		
		Random r = new Random();
		int rNum = r.nextInt(2000);
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "steef");
		jobj.put("projectName", "Ducati"+rNum);
		jobj.put("status", "On Going");
		jobj.put("teamSize", 10);
		
		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jobj);
		
		Response res = reqspec.put("http://localhost:8084/projects/TY_PROJ_2009");
		ValidatableResponse valres = res.then();
		valres.assertThat().statusCode(200);
		valres.log().all();
		
	}

}
