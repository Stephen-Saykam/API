package crudOperations_Without_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllProjectsTest {
	@Test
	public void getAllprojectsTest()
	{
		Response ra = RestAssured.get("http://localhost:8084/projects");
//		System.out.println(ra.asString());
//		//for getting the result in a proper way.Use PrettyPrint in print statement
//		System.out.println(ra.prettyPrint());
//		System.out.println(ra.getContentType());
//		System.out.println(ra.getStatusCode());
		
		ValidatableResponse valresp = ra.then();
		valresp.assertThat().statusCode(200);
		valresp.assertThat().contentType("application/json");
		valresp.log().all();
		System.out.println("Print");
		
	}

}
