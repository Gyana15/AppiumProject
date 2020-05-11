package com.shopping.demo.utils;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shopping.demo.Resources.TestConstants.TestConstants;
import com.shopping.demo.base.AppiumBaseClass;
import com.shopping.demo.base.AppiumController;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class UtilFunctions extends AppiumBaseClass{
	
	String propertyFileName;
	Properties prop;
	
	AppiumBaseClass baseDriver = new UtilFunctions();
	WebDriverWait wait = new WebDriverWait(AppiumController.instance.driver, 30);
	
	MobileElement mobileElement;
	List<MobileElement> mobileElements;
	Dimension size;
	private TouchAction _touchAction;
	
	protected String getPageSource() {
		return AppiumController.instance.driver.getPageSource();
	}
	
	@SuppressWarnings("rawtypes")
	protected AppiumDriver getDriver() {
		return AppiumController.instance.driver;
	}
	
	//------Load Environment Property-----------
	
	protected String getAppVersion() throws IOException{
		prop  = LoadConstants.loadProperty(TestConstants.ENV_PROPERTY_FILE_PATH, TestConstants.ENV_PROPERTY_FILE_NAME);	
		String[] appver = prop.getProperty("APP_VERSION").split(".");
		String fileName = appver[0]+"_"+appver[1]+".properties";
		return fileName;
	}

	// -------SendText to the text box---
	protected void inputString(String objectName, String stringToBeEntered) throws IOException {
		mobileElement = waitTillElementVisible(objectName);
		mobileElement.sendKeys(stringToBeEntered);
		AppiumController.instance.driver.hideKeyboard();
	}

	// -------Click on Element---
	protected void clickElement(String object) throws IOException {
		mobileElement = waitTillElementVisible(object);
		mobileElement.click();
	}
	
	//------Select from dropdown-------
	protected Select selectFromDropdown(String object) throws IOException{
		mobileElement = waitTillElementVisible(object);
		Select select = new Select(mobileElement);
		return select;
	}
	
	// ----------Get value of attribute---
	protected String getAttribute(String object, String attr) throws IOException {
		mobileElement = waitTillElementVisible(object);
		return mobileElement.getAttribute(attr);
	}
	
	// -------Get Mobile Element---
	protected MobileElement getElement(String object) throws IOException{
		mobileElement = waitTillElementVisible(object);
		return mobileElement;
	}
	
	//---------------Get Mobile Elements------
	protected List<MobileElement> getElements(String object) throws IOException{
		mobileElements = waitTillElementsVisible(object);
		return mobileElements;
	}
	
	//------------Get Element Text---------------
	protected String getElementText(String object) throws IOException {
		mobileElement = waitTillElementVisible(object);
		return mobileElement.getText();
	}

	//-------Navigate Back---
	protected void goBack() {
		AppiumController.instance.driver.navigate().back();
	}
	
	//----------Get touch Action Driver----------
	@SuppressWarnings("rawtypes")
	private TouchAction touchAction() {
	if (_touchAction == null) {
	_touchAction = new TouchAction(getDriver());
	}
	return _touchAction;
	}
	
	//----------Swipe on screen----------
	@SuppressWarnings("rawtypes")
	public void swipeOnScreen(Point fromPoint, Point toPoint) {

	WaitOptions waitOptions = new WaitOptions().withDuration(Duration.ofMillis(300));
	touchAction().press(new PointOption().withCoordinates(fromPoint)).waitAction(waitOptions).moveTo(new PointOption().withCoordinates(toPoint)).waitAction().release().perform();
	}

	//-----------------Scroll in android------
	public WebElement AndroidScrollable(String Text){

	WebElement element = getDriver().findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+Text+"\").instance(0)"));
	return element;
	}

	//----------rotate screen----------
	public void rotateScreen(String orientation){
		if(orientation.equalsIgnoreCase("LANDSCAPE")){
			getDriver().rotate(ScreenOrientation.LANDSCAPE);
		}
		else 
			if(orientation.equalsIgnoreCase("PORTRAIT")){
				getDriver().rotate(ScreenOrientation.PORTRAIT);
			}
	}

	//----------Set screen Resolution----------
	protected void setScreenResolution(int base, int height){
		getDriver().manage().window().setSize(new Dimension(base, height));
	}
	
	protected boolean isVisible(String object) {
		boolean status = false;
		try {
			mobileElement = waitTillElementVisible(object);
			status = true;
		} catch (Exception e) {

		}
		return status;
	}

	private MobileElement waitTillElementVisible(String object) throws IOException {
		
		propertyFileName = getAppVersion();
		String[] objectPropertyValue = LoadConstants.loadConstants(object, propertyFileName);
		if(objectPropertyValue[0].equalsIgnoreCase("id")){
			mobileElement= (MobileElement) getDriver().findElementById(objectPropertyValue[1]);
		}
		else if(objectPropertyValue[0].equalsIgnoreCase("xpath")){
			mobileElement= (MobileElement) getDriver().findElementByXPath(objectPropertyValue[1]);
		}
		else if(objectPropertyValue[0].equalsIgnoreCase("name")){
			mobileElement= (MobileElement) getDriver().findElementByName(objectPropertyValue[1]);
		}
		else if(objectPropertyValue[0].equalsIgnoreCase("class")){
			mobileElement= (MobileElement) getDriver().findElementByClassName(objectPropertyValue[1]);
		}
		else if(objectPropertyValue[0].equalsIgnoreCase("accessId")){
			mobileElement= (MobileElement) getDriver().findElementsByAccessibilityId(objectPropertyValue[1]);
		}
		else if(objectPropertyValue[0].equalsIgnoreCase("css")){
			mobileElement= (MobileElement) getDriver().findElementsByCssSelector(objectPropertyValue[1]);
		}
		else if(objectPropertyValue[0].equalsIgnoreCase("link")){
			mobileElement= (MobileElement) getDriver().findElementByLinkText(objectPropertyValue[1]);
		}
		
		return (MobileElement) wait.until(ExpectedConditions.visibilityOf(mobileElement));

	}
	
@SuppressWarnings("unchecked")
private List<MobileElement> waitTillElementsVisible(String object) throws IOException {
		propertyFileName = getAppVersion();
		String[] objectPropertyValue = LoadConstants.loadConstants(object, propertyFileName);
		if(objectPropertyValue[0].equalsIgnoreCase("id")){
			mobileElements= (List<MobileElement>) getDriver().findElementsById(objectPropertyValue[1]);
		}
		else if(objectPropertyValue[0].equalsIgnoreCase("xpath")){
			mobileElements= (List<MobileElement>) getDriver().findElementsByXPath(objectPropertyValue[1]);
		}
		else if(objectPropertyValue[0].equalsIgnoreCase("name")){
			mobileElements= (List<MobileElement>) getDriver().findElementsByName(objectPropertyValue[1]);
		}
		else if(objectPropertyValue[0].equalsIgnoreCase("class")){
			mobileElements= (List<MobileElement>) getDriver().findElementsByClassName(objectPropertyValue[1]);
		}
		else if(objectPropertyValue[0].equalsIgnoreCase("accessId")){
			mobileElements= (List<MobileElement>) getDriver().findElementsByAccessibilityId(objectPropertyValue[1]);
		}
		else if(objectPropertyValue[0].equalsIgnoreCase("css")){
			mobileElements= (List<MobileElement>) getDriver().findElementsByCssSelector(objectPropertyValue[1]);
		}
		else if(objectPropertyValue[0].equalsIgnoreCase("link")){
			mobileElements= (List<MobileElement>) getDriver().findElementsByLinkText(objectPropertyValue[1]);
		}
		
		return mobileElements;

	}
}
