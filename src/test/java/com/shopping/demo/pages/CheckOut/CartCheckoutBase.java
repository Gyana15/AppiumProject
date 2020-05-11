package com.shopping.demo.pages.CheckOut;

import java.io.IOException;

import com.shopping.demo.utils.UtilFunctions;

public abstract class CartCheckoutBase extends UtilFunctions implements CartCheckOut{
public abstract void checkOut() throws IOException;
}
