package requestChaining;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class RequestChainingTest {
	
	//@Test
	public void requestChainingTest()
	{
		Response resp = given().get("http://localhost:8084/projects");
		resp.then().assertThat().statusCode(200);
		
		String proID = resp.jsonPath().get("[0].projectName");
		
	}

}
