package com.inetBanking.testCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{

	@Test
	public void loginTest() throws IOException
	{
		driver.get(baseUrl);
		
		    logger.info("URL is Opened");
		
		LoginPage lp= new LoginPage(driver);
		
		lp.setUserName(username);
		
		    logger.info("Entered Username");

		
		lp.setPassword(password);
		
		     logger.info("Password Entered");
		 
			lp.clickSubmit();
		
	//System.out.println(driver.getTitle());
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		
		else
		{
			captureScreen( driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
		
	}
}
