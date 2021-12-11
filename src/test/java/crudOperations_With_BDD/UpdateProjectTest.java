package crudOperations_With_BDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateProjectTest {
	
	@Test
	public void updateProject()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "steef");
		jobj.put("projectName", "TYSS_789");
		jobj.put("status", "On Going");
		jobj.put("teamSize", 10);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1005")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}

}
