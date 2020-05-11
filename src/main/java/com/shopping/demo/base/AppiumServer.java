package com.shopping.demo.base;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;


public class AppiumServer {
	
	
	//Appium Launch on Windows
	private static Process process;

	//Calling the node.exe and appium.js
	private static String STARTSERVER = "C:\\Users\\Selenium\\Desktop\\Appium\\Appium\\node.exe C:\\Users\\Selenium\\Desktop\\Appium\\Appium\\node_modules\\appium\\bin\\appium.js";

	
	
	
	//Starting the Appium Server
	
	public static void start() throws IOException, InterruptedException {

	Runtime runtime = Runtime.getRuntime();

	process = runtime.exec(STARTSERVER);

	Thread.sleep(7000);

	if (process != null) {

	System.out.println("Appium server started");

	}

	}

	
	//Stopping the Appium Server
	
	public static void stop() throws IOException {

	if (process != null) {

	process.destroy();

	}

	System.out.println("Appium server stopped");

	}


}
