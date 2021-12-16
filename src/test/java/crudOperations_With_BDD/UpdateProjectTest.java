package crudOperations_With_BDD;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateProjectTest {
	
	@Test
	public void updateProject()
	{
		Random r = new Random();
		int rNum = r.nextInt(2000);
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "steef");
		jobj.put("projectName", "TYSS"+rNum);
		jobj.put("status", "On Going");
		jobj.put("teamSize", 10);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1205")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}

}
