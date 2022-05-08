package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass {
	IndexPage indexpage ;
	SearchResultPage searchresultpage ;
	AddToCartPage addtocartpage ;

	@BeforeMethod
	public void setup() {
		launchapp();
	}
	@AfterMethod
	public void tearDown () {
		driver.quit();

	}
	@Test
	public void addToCartTest () {
		indexpage  = new IndexPage() ;
		indexpage.searchProduct("T-shirt");
		searchresultpage=indexpage.clickOnSearchButton();
		addtocartpage=searchresultpage.clickOnProduct();
		addtocartpage.enterQuantity("2");
		addtocartpage.selectSize("M");
		addtocartpage.clickOnAddToCart();
		boolean result =addtocartpage.validateAddToCart();
		Assert.assertTrue(result);
		
	}
	
}
