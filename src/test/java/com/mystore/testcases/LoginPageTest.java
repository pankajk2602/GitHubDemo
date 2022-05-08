package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass {

	IndexPage indexpage ;
	LoginPage loginpage;
	HomePage homepage ;
	@BeforeMethod
	public void setup() {
		launchapp();
	}
	@AfterMethod
	public void tearDown () {
		driver.quit();
	}
	@Test()
	public void loginTest() {
		indexpage = new IndexPage();
		loginpage =indexpage.clickOnSignIn();//click on sign in page
		Log.info("user is going to click on Signin");
		homepage=loginpage.login(prop.getProperty("username") , prop.getProperty("password"));
		//homepage=loginpage.login(uname , pswd);
		Log.info("Enter Username and Password");
		String	actualURL=homepage.getCurrentUrl() ;
		String expectedURL="http://automationpractice.com/index.php?controller=my-account";
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is success");
		Log.endTestCase("loginTest");

	}


}
