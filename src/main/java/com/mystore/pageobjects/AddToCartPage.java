package com.mystore.pageobjects;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.base.BaseClass;
public class AddToCartPage extends BaseClass {
	
	@FindBy(id = "quantity_wanted") private WebElement quantity;
	@FindBy(id = "group_1") private WebElement size;
	@FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span") private WebElement addToCart ;
	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2") private WebElement addToCartMessage ; 
	@FindBy(id = "layer_cart_product_title") private WebElement productTitle ;
	
	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span") private WebElement proceedToCheckOutBtn ;
	
	public AddToCartPage() {
		PageFactory.initElements(driver , this);
	}
	public void enterQuantity(String quant) {
		quantity.sendKeys(quant);
	}
	public void selectSize(String text) {
		Select d= new Select(size);
		d.selectByVisibleText(text);
	}
	public void clickOnAddToCart() {	
		JavascriptExecutor executor = (JavascriptExecutor) driver ;
		executor.executeScript("arguments[0].click();" , addToCart) ;
	}
	public boolean validateAddToCart() {
	FluentWait<WebDriver> wait = new FluentWait<WebDriver> (driver);
	wait.withTimeout(Duration.ofSeconds(10));
	wait.pollingEvery(Duration.ofSeconds(2));
	wait.ignoring(Exception.class);
	wait.until(ExpectedConditions.visibilityOf(addToCartMessage));
	
	return	addToCartMessage.isDisplayed();
	}
	public OrderPage clickOnCheckOut() {
		JavascriptExecutor executor = (JavascriptExecutor) driver ;
		executor.executeScript("arguments[0].click();" , proceedToCheckOutBtn);
		return new OrderPage() ;
	}
}
