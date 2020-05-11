package com.shopping.demo.pages.Login;

import java.io.IOException;

public interface LoginPage {
	
	public void login(String mode) throws IOException;
	
	public void login(String userName, String password) throws IOException;
	
	public void login() throws IOException;
	
	public void logOut() throws IOException;

}
