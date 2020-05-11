package com.shopping.demo.pages.Login;

import java.io.IOException;

import org.testng.Assert;

import com.shopping.demo.Resources.TestConstants.TestConstants;
import com.shopping.demo.utils.Excel_reader;


public class LoginPageAndroid extends LoginBasePage implements LoginPage {
	
	Excel_reader excel = new Excel_reader();
	
	@Override
	public void login(String userName, String passWord) throws IOException {

			clickElement(TestConstants.LOGIN_SIGNIN_LINK);
			inputString(TestConstants.LOGIN_USERNAME_TEXT_FIELD, userName);
			inputString(TestConstants.LOGIN_PASSWORD_TEXT_FIELD, passWord);
			clickElement(TestConstants.LOGIN_SUBMIT_BUTTON);
	}

	@Override
	public void login() throws IOException {
		clickElement(TestConstants.LOGIN_SIGNIN_LINK);
		inputString(TestConstants.LOGIN_USERNAME_TEXT_FIELD, excel.getDataWithColumnName(TestConstants.EXCEL_DATA_WORKBOOK, TestConstants.EXCEL_USER_DATA_SHEET, "USERID"));
		inputString(TestConstants.LOGIN_PASSWORD_TEXT_FIELD, excel.getDataWithColumnName(TestConstants.EXCEL_DATA_WORKBOOK, TestConstants.EXCEL_USER_DATA_SHEET, "PASSWORD"));
		clickElement(TestConstants.LOGIN_SUBMIT_BUTTON);
		
	}
	
	@Override
	public void login(String mode) throws IOException {
		rotateScreen(mode);
		clickElement(TestConstants.LOGIN_SIGNIN_LINK);
		inputString(TestConstants.LOGIN_USERNAME_TEXT_FIELD, excel.getDataWithColumnName(TestConstants.EXCEL_DATA_WORKBOOK, TestConstants.EXCEL_USER_DATA_SHEET, "USERID"));
		inputString(TestConstants.LOGIN_PASSWORD_TEXT_FIELD, excel.getDataWithColumnName(TestConstants.EXCEL_DATA_WORKBOOK, TestConstants.EXCEL_USER_DATA_SHEET, "PASSWORD"));
		clickElement(TestConstants.LOGIN_SUBMIT_BUTTON);
		
	}

	@Override
	public void logOut() throws IOException {
		clickElement(TestConstants.HOME_SCREEN_LOG_OUT_LINK);
		if(isVisible(TestConstants.HOME_SCREEN_LOGOUT_CONFIRM)){
			clickElement(TestConstants.HOME_SCREEN_LOGOUT_CONFIRM);
		}
		Assert.assertTrue(isVisible(TestConstants.HOME_SCREEN_LOGOUT_MESSAGE));
	}

}
