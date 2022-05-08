package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderSummaryPage extends BaseClass {
	@FindBy(xpath = "//button[@class=\"button btn btn-default button-medium\"]") private WebElement confirmOrder ;

	public OrderSummaryPage() {
		PageFactory.initElements(driver, this);
	}
	public OrderConfirmationPage clickOnConfirmOrder() {

		confirmOrder.click();
		return new OrderConfirmationPage(); 
	}

}
