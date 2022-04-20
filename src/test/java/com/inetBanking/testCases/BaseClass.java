package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilites.ReadConfig;


public class BaseClass {
	
	ReadConfig readconfig= new ReadConfig();

	public String baseUrl=readconfig.getApplicationURL();
	public String username=readconfig.getusername();
	public String password=readconfig.getpassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	
@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");	
		//driver.manage().window().maximize();
		 logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());	
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		}
		else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxpath());	
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			
		}
		else if(br.equals("ie"))
		{
			
			System.setProperty("webdriver.ie.driver", readconfig.getiepath());	
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}
	
}
