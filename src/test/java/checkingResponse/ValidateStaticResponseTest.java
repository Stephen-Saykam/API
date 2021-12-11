package checkingResponse;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class ValidateStaticResponseTest {
	
	@Test
	public void valideStaticResponseTest()
	{
		String expData = "TYSS_4545";
		
		Response resp = when().get("http://localhost:8084/projects");
		resp.then().assertThat().statusCode(200);
		
		String actData = resp.jsonPath().get("[4].projectName");
		
		System.out.println(actData);
		
		Assert.assertEquals(actData, expData);
		
	}

}
