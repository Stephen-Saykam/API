package different_Ways_To_Create_JSONFiles;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectHashMapTest {
	
	@Test
	public void createProjectHashMapTest()
	{
		HashMap hp = new HashMap();
		hp.put("createdBy", "steef");
		hp.put("projectName", "TYSS_2244");
		hp.put("status", "On Going");
		hp.put("teamSize", 10);
		
		given()
		.contentType(ContentType.JSON)
		.body(hp)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}

}
