package hamcrest;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class ValidatingResponseTimeTest {
	
	@Test
	public void validatingResponseTimeTest()
	{
//		when()
//		.get("http://localhost:8084/projects")
//		.then()
//		.assertThat().time(Matchers.lessThan(5000L),TimeUnit.MILLISECONDS)
//		.log().all();
		
		
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().time(Matchers.lessThan(5000L),TimeUnit.MILLISECONDS)
		.assertThat().body("[2].projectName", Matchers.equalTo("Jyothika"))
		.log().all();
	}

}
