package com.shopping.demo.Run;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.shopping.demo.base.AppiumBaseClass;
import com.shopping.demo.base.AppiumController;

import io.appium.java_client.AppiumDriver;

public class Listeners extends AppiumController implements ITestListener{
	ExtentReports extent;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	ExtentTest test;
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		extentTest.get().fail(arg0.getThrowable());
		Object testObject = arg0.getInstance();
		Class clazz = arg0.getTestClass().getRealClass();
		try {
			WebDriver driver = (WebDriver)clazz.getDeclaredField("driver").get(testObject);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshotPath(arg0.getMethod().getMethodName(),driver), arg0.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getScreenshotPath(String TestCaseName, AppiumDriver<?> driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir") + "\\reports"+TestCaseName+".png";
		FileUtils.copyFile(source, new File(destPath));
		
		return destPath;
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		test = extent.createTest(arg0.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Successfull");
	}

}
