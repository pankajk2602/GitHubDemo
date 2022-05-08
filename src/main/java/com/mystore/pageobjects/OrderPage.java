package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {
	@FindBy(xpath = "(//span[@class=\"price\"])[3]") private WebElement unitPrice ;
    @FindBy(id = "total_price") private WebElement totalPrice ; 
    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span/text()") private WebElement proceedToCheck ;
    
    public OrderPage() {
    	PageFactory.initElements(driver , this) ;
    }

    public double getUnitPrice() {
    	FluentWait<WebDriver> wait = new FluentWait<WebDriver> (driver);
    	wait.withTimeout(Duration.ofSeconds(10));
    	wait.pollingEvery(Duration.ofSeconds(2));
    	wait.ignoring(Exception.class);
    	wait.until(ExpectedConditions.visibilityOf(unitPrice));
    	String unitPrice1=unitPrice.getText();
    	String rs =unitPrice1.replaceAll("$"," ");
    	double finalUnitPrice=Double.parseDouble(rs);
    	return finalUnitPrice/100 ;
    }
    
    public double getTotalPrice() {
    	String unitPrice1=totalPrice.getText();
    	String rs =unitPrice1.replaceAll("$"," ");
    	double finalUnitPrice=Double.parseDouble(rs);
    	return finalUnitPrice/100 ;
    	
    }
    
    
    public LoginPage clickOnCheckOut() {
    	FluentWait<WebDriver> wait = new FluentWait<WebDriver> (driver);
    	wait.withTimeout(Duration.ofSeconds(100));
    	wait.pollingEvery(Duration.ofSeconds(5));
    	wait.ignoring(Exception.class);
    	wait.until(ExpectedConditions.visibilityOf(proceedToCheck));
    	JavascriptExecutor executor = (JavascriptExecutor) driver ;
		executor.executeScript("arguments[0].click();" , proceedToCheck);
    	
		return new LoginPage() ;
    	
    	
    }
    
    
    
    
}
