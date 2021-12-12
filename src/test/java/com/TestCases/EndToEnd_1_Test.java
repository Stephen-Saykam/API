package com.TestCases;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.RMGYantra_POJO_Library.Pojo_Librery;
import com.mysql.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndToEnd_1_Test {
	
	@Test

	public void endToEnd() throws Throwable
	{
		Random r = new Random();
		int rNum = r.nextInt(2000);
		
		Pojo_Librery pl=new Pojo_Librery("Siva", "Sonovision"+rNum, "On Going", 5);
		
		//Create a Project
		Response resp = given().contentType(ContentType.JSON).body(pl).when().post("http://localhost:8084/addProject");
		
		//Verify the created Project
		resp.then()
		.assertThat().statusCode(201)
		.and().time(Matchers.lessThan(5000L),TimeUnit.MILLISECONDS)
		.log().all();
		
		//Take the Project ID from Response
		String pId = resp.jsonPath().get("projectId");
		System.out.println(pId);
		
		//Get the Project from project ID
		Response resp1 = given().pathParam("proId", pId).when().get("http://localhost:8084/projects/{proId}");
		
		//Take ProjectName from Response
		String pName = resp1.jsonPath().get("projectName");
		
		//Connecting DataBase
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery("select * from project;");
		
		while(res.next())
		{
			if(pName.equals(res.getString(4)))
			{
				System.out.println(pName+" is Matching");
			}
		}
		
		con.close();
		
		
	}
}
