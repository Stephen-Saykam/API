package different_Ways_To_Create_JSONFiles;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectJSONObjectRandomWayTest {
	
	@Test
	public void createProjectJSONObjectRandomWayTest()
	{
		Random rd = new Random();
		int rnum = rd.nextInt(2000);
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "steef");
		jobj.put("projectName", "TYSS"+rnum+"");
		jobj.put("status", "On Going");
		jobj.put("teamSize", 10);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}

}
