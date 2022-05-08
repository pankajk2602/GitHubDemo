package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {

	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a") private WebElement signInBtn;
	@FindBy(xpath = "//*[@id=\"header_logo\"]/a/img") private WebElement myStoreLogo ;
	@FindBy(id = "search_query_top") private WebElement searchProductBox ;
	@FindBy(name = "submit_search") private WebElement searchButton;
	
	public IndexPage() {
		PageFactory.initElements(driver , this);	
	}
	
	public LoginPage clickOnSignIn() {
		
		signInBtn.click();	
		
		return new LoginPage() ;
	}
	public boolean validateLogo() {
		
	return	myStoreLogo.isDisplayed();
	}
	public String getMyStoreTitle() {
		
		return driver.getTitle();
	}
	public void searchProduct( String productName) {
		
		searchProductBox.clear();
		searchProductBox.sendKeys(productName);
	}
	public SearchResultPage clickOnSearchButton() {
		searchButton.click();
		return new SearchResultPage();
	}
	
	
	
	
}
