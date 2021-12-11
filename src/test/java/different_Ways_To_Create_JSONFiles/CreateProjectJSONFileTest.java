package different_Ways_To_Create_JSONFiles;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectJSONFileTest {
	
	@Test
	public void createProjectJSONFileTest()
	{
		File fl = new File("./File.json");
		
		given()
		.contentType(ContentType.JSON)
		.body(fl)
		
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}

}
