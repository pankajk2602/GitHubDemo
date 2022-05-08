package com.mystore.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass {
	@FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span") private WebElement proceedToCheck ;

	public AddressPage() {
		PageFactory.initElements(driver , this);

	}
	public ShippingPage clickOnCheckOut() {
		JavascriptExecutor executor = (JavascriptExecutor) driver ;
		executor.executeScript("arguments[0].click();" , proceedToCheck );
		return new ShippingPage() ;


	}






}
