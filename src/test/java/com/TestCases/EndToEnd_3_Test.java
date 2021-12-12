package com.TestCases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.RMGYantra_Generic_Librery.BaseClass;
import com.RMGYantra_Generic_Librery.DataBaseUtility;
import com.RMGYantra_Generic_Librery.EndPoints;
import com.RMGYantra_Generic_Librery.JSONUtility;
import com.RMGYantra_Generic_Librery.JavaUtility;
import com.RMGYantra_POJO_Library.Pojo_Librery;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndToEnd_3_Test extends BaseClass implements EndPoints {
	
	@Test
	public void end_To_End() throws Throwable
	{
		JavaUtility jUtil = new JavaUtility();
		JSONUtility jsUtil = new JSONUtility();     //for JSON Path
		DataBaseUtility dbUtil = new DataBaseUtility();
		
		Pojo_Librery pl = new Pojo_Librery("Arun", "Kakinada"+jUtil.randomNum(), "Created", 8);
		
		baseURI="http://localhost";
		port=8084;
		
		//Create a Project
		Response resp = given().contentType(ContentType.JSON).body(pl).when().post(EndPoints.CreateProj);
		
		//Verify the Created Project
		resp.then()
		.assertThat().statusCode(201).and()
		.time(Matchers.lessThan(5000L),TimeUnit.MILLISECONDS)
		.log().all();
		
		//Take the Project ID from response
//		String pId = resp.jsonPath().get("projectId");   // this is hard code
		String pId = jsUtil.jsonPathFinder("projectId", resp);
		System.out.println(pId);
		
		//Get Project from Project ID
		Response resp1 = given().pathParam("proId", pId).when().get("http://localhost:8084/projects/{proId}");
		
		//Take Project Name from Response
		
//		String pName = resp1.jsonPath().get("projectName"); //This is Hard Code
		
		String pName = jsUtil.jsonPathFinder("projectName", resp1);
		System.out.println(pName);
		
		//Connect to DataBase
		dbUtil.connectToDB();
		
//		Statement state = con.createStatement();
//		ResultSet res = state.executeQuery("select * from project"); //This is hard Code
		ResultSet res = dbUtil.executeQuery("select * from project;");
		
		while(res.next())
		{
			if(pName.equals(res.getString(4)))
			{
				System.out.println(pName+" is Matching");
			}
		}
		
		//Deleting the created project
		
		given().pathParam("proId", pId).when().delete("http://localhost:8084/projects/{proId}")
		.then().assertThat().statusCode(204).log().all();
		
	}

}
