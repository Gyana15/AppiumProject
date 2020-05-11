package com.shopping.demo.pages.CheckOut;

import java.io.IOException;

import org.testng.Assert;

import com.shopping.demo.Resources.TestConstants.TestConstants;

public class CartCheckoutAndroid extends CartCheckoutBase implements CartCheckOut {

	@Override
	public void checkOut() throws IOException {
		Assert.assertTrue(isVisible(TestConstants.CART_SCREEN_CHCKOUT));
		clickElement(TestConstants.CART_SCREEN_CHCKOUT);
	}

}
