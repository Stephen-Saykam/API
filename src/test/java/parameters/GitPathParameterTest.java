package parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GitPathParameterTest {
	
	@Test
	public void gitPathParameterTest()
	{
//		given()
//		.pathParam("username", "Stephen-Saykam")
//		.when()
//		.get("https://api.github.com/users/{username}/repos")
//		.then()
//		.log()
//		.all();
		
		given()
		.pathParam("username", "Stephen-Saykam")
		.queryParam("sort", "created")
		.when()
		.get("https://api.github.com/users/{username}/repos")
		.then()
		.log().all();
	}

}
