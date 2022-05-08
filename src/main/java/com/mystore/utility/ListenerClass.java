package com.mystore.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mystore.base.BaseClass;





public class ListenerClass extends ExtentManager implements ITestListener {
	public void onTestStart(ITestResult result) {
	test = extent.createTest(result.getName()) ;
	test.createNode(result.getName());
	}
	
	public void onTestFailureScreenshot(ITestResult result)throws IOException {
	
		try {
			if(result.getStatus() == ITestResult.FAILURE ) {
				File source = ((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.FILE);
				File Destination = new File("C:\\Users\\kulth\\eclipse-workspace\\MyStoreProject\\ScreenShot"+result.getName()+".png");
				FileHandler.copy(source, Destination);
				test.log(Status.FAIL , MarkupHelper.createLabel(result.getName() + "Test Case is failed", ExtentColor.ORANGE));
			test.fail("Screenshot is Attached" , MediaEntityBuilder);
			}
		}

		catch(IOException e){
			e.printStackTrace();
		}
		
}}
