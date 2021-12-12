package com.RMGYantra_Generic_Librery;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	DataBaseUtility dbUtil=new DataBaseUtility();
	
	@BeforeSuite
	public void connectDataBase()
	{
		dbUtil.connectToDB();
		System.out.println("Connect to Database");
	}
	
	@AfterSuite
	public void disConnectDataBase() throws SQLException
	{
		dbUtil.closeDB();
		System.out.println("Diconnect to DataBase");
	}

}
