package crudOperations_With_BDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteProjectTest {
	
	@Test
	public void deleteProjectTest()
	{
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_1005")
		
		.then()
		.assertThat()
		.statusCode(204)
		.and()
		.contentType(ContentType.JSON)
		.and()
		.log()
		.all();
	}

}
