package com.RMGYantra_Generic_Librery;

import java.util.Random;

import org.testng.annotations.Test;

public class JavaUtility {
	
	@Test
	public int randomNum()
	{
		Random r = new Random();
		int rnum = r.nextInt(2000);
		return rnum;
		
	}

}
