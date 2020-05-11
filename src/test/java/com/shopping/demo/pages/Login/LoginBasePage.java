package com.shopping.demo.pages.Login;

import java.io.IOException;

import com.shopping.demo.utils.UtilFunctions;

public abstract class LoginBasePage extends UtilFunctions implements LoginPage{
	
	public abstract void login(String mode) throws IOException;
	
	public abstract void login(String userName, String password) throws IOException;
	
	public abstract void login() throws IOException;
	
	public abstract void logOut() throws IOException;
}
