package com.mystore.base;
import java.io.FileInputStream;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mystore.utility.ExtentManager;
import com.mystore.utility.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop ;
	public static WebDriver driver ;

	@BeforeSuite
	public void loadconfig() {
		ExtentManager.setExtent();

		DOMConfigurator.configure("log4j.xml");
		try {
			prop = new Properties();
			System.out.println("super constructor invoked");
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop.load(ip);
			System.out.println("driver: " + driver);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}  catch (IOException e)
		{
			e.printStackTrace();
		
		}
	}



	public static void launchapp() {
		WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browser");

		if (browserName.contains("Chrome")) {
			driver = new ChromeDriver();
		}
		else if (browserName.contains("IE"))
		{
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2000 , TimeUnit.MILLISECONDS)	;
		driver.get(prop.getProperty("url"));
}
	@AfterSuite
	public void aftersuite() {
		ExtentManager.endReport();
	}
}