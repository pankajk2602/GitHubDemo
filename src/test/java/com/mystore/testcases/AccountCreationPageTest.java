package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass {

	IndexPage indexpage ;
	LoginPage loginpage;
	HomePage homepage ;
	AccountCreationPage accountcreationpage ;

	@BeforeMethod
	public void setup() {
		launchapp();
	}
	@AfterMethod
	public void tearDown () {
		driver.quit();

	}
	@Test
	public void verifyCreateAccountTest() {
		indexpage = new IndexPage() ;
		loginpage= indexpage.clickOnSignIn();
		accountcreationpage = loginpage.createNewAccount("pck@kkk.com");
		boolean result =accountcreationpage.validateAccountCreationPage() ;
		Assert.assertTrue(result);
	}







}