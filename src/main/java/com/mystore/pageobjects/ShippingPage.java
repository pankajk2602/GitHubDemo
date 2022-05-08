package com.mystore.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {

	
	@FindBy(name = "processCarrier") private WebElement agreeTerms ;
	@FindBy(xpath = "//*[@id=\"form\"]/p/button/span") private WebElement proceedToCheckOut ;
	
	
	public ShippingPage() {
		
		PageFactory.initElements(driver , this);
	}
	public void checkTheTerms() {
		JavascriptExecutor executor = (JavascriptExecutor) driver ;
		executor.executeScript("arguments[0].click();" , agreeTerms) ;
	}
	
	public PaymentPage clickOnProceed() {
		
		proceedToCheckOut.click();
		return new PaymentPage();
		
	}
	
	
	
	
	
	
}
