package parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PathParameterTest {
	
	@Test
	public void pathParameterTest()
	{
		given()
		.contentType(ContentType.JSON)
		.pathParam("proID", "TY_PROJ_1403")
		
		.when()
		.get("http://localhost:8084/projects/{proID}")
		.then()
		.log().all();
	}

}
