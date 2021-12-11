package crudOperations_Without_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteProjectsTest {
	@Test
	public void deleteProjectsTest()
	{
		Response ra = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1004");
		System.out.println(ra.getStatusCode());
		ValidatableResponse valresp = ra.then();
		valresp.assertThat().statusCode(204);
	}

}
