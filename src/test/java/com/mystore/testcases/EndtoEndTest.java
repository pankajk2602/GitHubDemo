package com.mystore.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

public class EndtoEndTest extends BaseClass {
	IndexPage indexpage ;
	SearchResultPage searchresultpage ;
	AddToCartPage addtocartpage ;
	OrderPage orderpage ;
	LoginPage loginpage ;
	AddressPage addresspage ;
	ShippingPage shippingpage ;
	PaymentPage paymentpage ;
	OrderSummaryPage ordersummary ;
	OrderConfirmationPage orderconfirmationpage;
	@BeforeMethod
	public void setup() {
		launchapp();
	}
	@AfterMethod
	public void tearDown () {
	//	driver.quit();

	}
	@Test
	public void endtoEndTest() {
		indexpage  = new IndexPage() ;
		indexpage.searchProduct("T-shirt");
		searchresultpage=indexpage.clickOnSearchButton();
		addtocartpage=searchresultpage.clickOnProduct();
		addtocartpage.enterQuantity("2");
		addtocartpage.selectSize("M");
		addtocartpage.clickOnAddToCart();
		loginpage = orderpage.clickOnCheckOut();
		addresspage =loginpage.login1(prop.getProperty("username") , prop.getProperty("password")) ;
		shippingpage=addresspage.clickOnCheckOut();
		shippingpage.checkTheTerms();
		paymentpage=shippingpage.clickOnProceed();
		ordersummary=paymentpage.clickOnPaymentMethod();
		orderconfirmationpage=ordersummary.clickOnConfirmOrder();
		String actual=orderconfirmationpage.validateConfirmMessage();
		String expected="Your order on My Store is complete.";
		Assert.assertEquals(actual , expected);
	}
}
