package com.shopping.demo.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author syam
 *
 */
public class AppiumController {

	public static OS executionOS = OS.ANDROID;

	public enum OS {
		ANDROID
	}

	public static AppiumController instance = new AppiumController();
	public AppiumDriver<?> driver;
@BeforeSuite
	public void start() throws IOException, InterruptedException {
		if (driver != null) {
			return;
		}
		switch (executionOS) {
		case ANDROID:
			AppiumServer.stop();
			AppiumServer.start();
			CommonUtils.loadConfigProp("app.properties");
			CommonUtils.setCapabilities();
			driver = CommonUtils.getDriver();
			break;
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
@AfterSuite

	public void stop() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
