package crudOperations_With_BDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetProjectTest {
	
	@Test
	public void getProjectTest()
	{
		when()
		.get("http://localhost:8084/projects")
		
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.contentType(ContentType.JSON)
		.log()
		.all();
	}

}
