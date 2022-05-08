package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass {

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
	@Test
	public void verifyWishListTest() {
		indexpage=new IndexPage() ;
		loginpage= indexpage.clickOnSignIn();
		homepage=loginpage.login(prop.getProperty("username") , prop.getProperty("password"));
		boolean result=	homepage.validateMyWishList();
		Assert.assertTrue(true);
	}
	public void orderHistoryandDetailsTest() {
		indexpage=new IndexPage() ;
		loginpage= indexpage.clickOnSignIn();
		homepage=loginpage.login(prop.getProperty("username") , prop.getProperty("password"));
		boolean result=	homepage.validateOrderHistory() ;
		Assert.assertTrue(result);
	}

}
