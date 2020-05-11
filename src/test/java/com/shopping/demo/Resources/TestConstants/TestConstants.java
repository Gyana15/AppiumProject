package com.shopping.demo.Resources.TestConstants;

public class TestConstants {

	//-----------Get Utils TestData Location and sheet ---------------
	public static final String EXCEL_DATA_WORKBOOK = System.getProperty("user.dir")+"src\\test\\java\\com\\shopping\\demo\\Resources\\TestData\\TestUserData.xlsx";
	public static final String EXCEL_USER_DATA_SHEET = "User_Data";
	public static final String EXCEL_TEST_DATA_SHEET = "Test_Data";
	public static final String ENV_PROPERTY_FILE_PATH = System.getProperty("user.dir")+"src\\main\\java\\com\\shopping\\demo\\resources\\EnvironmentProperties\\";
	public static final String ENV_PROPERTY_FILE_NAME = "env.properties";
	
	//-----------------Login Screen-----------------
	public static String LOGIN_SIGNIN_LINK = "loginScreen.signInLink";
	public static String LOGIN_USERNAME_TEXT_FIELD = "loginScreen.usernameTextField";
	public static String LOGIN_PASSWORD_TEXT_FIELD = "loginScreen.passwordTextField";
	public static String LOGIN_SUBMIT_BUTTON = "loginScreen.loginSubmitButton";
	
	//-----------------Search Screen--------------------------
	public static String SEARCH_SCREEN_ITEM_TEXT_FIELD = "searchScreen.searchItemTextField";
	public static String SEARCH_SCREEN_SEARCH_BUTTON = "searchScreen.searchButton";
	public static String SEARCH_FIRST_ELEMENT_LABEL = "searchScreen.firstElement";
	public static String SEARCH_SCREEN_ADDTOCART_ICON = "searchScreen.addToCart";
	public static String SEARCH_SCREEN_ALL_ELEMENTS = "searchScreen.AllElements";
	public static String SEARCH_SCREEN_ELEMENT_PRICE = "searchScreen.ElementPrice";
	public static String SEARCH_SCREEN_ELEMENT_DESCRIPTION = "searchScreen.ElementDescription";
	
	//------------------Cart Screen----------------------
	public static String CART_SCREEN_ADDTOCART_ICON_BUTTON = "addToCart.cartIcon";
	public static String CART_SCREEN_CHECK_ITEMS = "addToCart.checkCart";
	public static String CART_SCREEN_CHCKOUT = "addToCart.checkOut";
	public static String CART_SCREEN_CHECK_ITEM_NAME = "cartItem.ItemName";
	public static String CART_SCREEN_CHECK_ITEM_PRICE = "cartItem.ItemPrice";
	public static String CART_SCREEN_CHECK_ITEM_DESCRIPTION = "cartItem.ItemDescription";
	
	//-----------------LogOut----------------------------
	public static String HOME_SCREEN_LOG_OUT_LINK = "homeScreen.logOutLink";
	public static String HOME_SCREEN_LOGOUT_CONFIRM = "homeScreen.confirmLogOutYes";
	public static String HOME_SCREEN_LOGOUT_DENY = "homeScreen.confirmLogOutNo";
	public static String HOME_SCREEN_LOGOUT_MESSAGE = "homeScreen.logOutMessage";
}
