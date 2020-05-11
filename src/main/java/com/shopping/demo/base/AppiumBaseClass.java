package com.shopping.demo.base;

import io.appium.java_client.AppiumDriver;

/**
 * @author syam
 *
 */
public abstract class AppiumBaseClass {

	protected AppiumDriver<?> driver() {
		return AppiumController.instance.driver;
	}

}
