package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {
	@FindBy(id="email") private WebElement userName;
	@FindBy(id = "passwd")private WebElement password ;
	@FindBy(id = "SubmitLogin")private WebElement signInBtn ;
	@FindBy(id = "email_create")private WebElement emailForNewAccount ;
	@FindBy(id = "SubmitCreate")private WebElement createNewAccountBtn ;
	
	public LoginPage() {
		
		PageFactory.initElements(driver , this);
	}
	
	public HomePage login(String uname ,String pswd) {
		userName.sendKeys(uname);
		password.sendKeys(pswd);
		signInBtn.click();
		return new HomePage();
	}
	public AddressPage login1(String uname ,String pswd) {
		userName.sendKeys(uname);
		password.sendKeys(pswd);
		signInBtn.click();
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String newemail) {
		emailForNewAccount.sendKeys(newemail);
		createNewAccountBtn.click();
		return new AccountCreationPage();
	}


}
