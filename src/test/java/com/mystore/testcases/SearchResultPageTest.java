package com.mystore.testcases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;

import com.mystore.pageobjects.IndexPage;

import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {

	IndexPage indexpage ;
	SearchResultPage searchresultpage ;

	@BeforeMethod
	public void setup() {
		launchapp();
	}
	@AfterMethod
	public void tearDown () {
		driver.quit();

	}
	@Test
	public void productAvabiltityTest() {
		indexpage = new IndexPage();
		indexpage.searchProduct("T-shirt");
		searchresultpage=indexpage.clickOnSearchButton();
		boolean result = searchresultpage.isProductAvailable() ; 
		Assert.assertTrue(result);
	}








}
