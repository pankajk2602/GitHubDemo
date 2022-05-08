package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {
	@FindBy(xpath = "//*[@id=\"center_column\"]/div/div[2]/ul/li/a/span") private WebElement myWishList;
	@FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span") private WebElement OrderHistory;

public HomePage() {
	PageFactory.initElements(driver, this);
}

public boolean validateMyWishList() {
	return myWishList.isDisplayed();
}

public boolean validateOrderHistory() {
	return OrderHistory.isDisplayed();
}
public String getCurrentUrl() {
	String homeUrl=driver.getCurrentUrl();
return homeUrl ;
}

}
