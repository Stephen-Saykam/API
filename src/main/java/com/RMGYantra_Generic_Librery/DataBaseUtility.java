package com.RMGYantra_Generic_Librery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	
	public Connection con= null;
	public ResultSet res;
	
	/**
	 * This method to connect to DataBase
	 */
	
	
	@Test
	public void connectToDB()
	{
		try 
		{
			Driver d = new Driver();
			DriverManager.registerDriver(d);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			
		} 
		
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * This method to close the Connection
	 * @throws SQLException
	 */
	
	public void closeDB() throws SQLException
	{
		con.close();
	}
	
	/**
	 * This method to execute query and return the result
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	
	public ResultSet executeQuery(String query) throws Throwable
	{
		ResultSet res = con.createStatement().executeQuery(query);
		return res;
		
	}

}
