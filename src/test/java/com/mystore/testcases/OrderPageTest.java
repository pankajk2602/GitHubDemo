package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	IndexPage indexpage ;
	SearchResultPage searchresultpage ;
	AddToCartPage addtocartpage ;
	OrderPage orderpage ;

	@BeforeMethod
	public void setup() {
		launchapp();
	}
	@AfterMethod
	public void tearDown () {
		driver.quit();

	}
	@Test
	public void verifyTotalPrice() {
	indexpage = new IndexPage() ;
	indexpage.searchProduct("T-shirt");
	searchresultpage=indexpage.clickOnSearchButton();
	addtocartpage=searchresultpage.clickOnProduct();
	addtocartpage.enterQuantity("2");
	addtocartpage.selectSize("M");
	addtocartpage.clickOnAddToCart();
	addtocartpage.clickOnCheckOut();
	Double unitprice = orderpage.getUnitPrice();
	Double totalprice = orderpage.getTotalPrice();
	Double totalexpectedprice= (unitprice*2)+2 ;
	Assert.assertEquals(totalprice , totalexpectedprice);	
	}
}
