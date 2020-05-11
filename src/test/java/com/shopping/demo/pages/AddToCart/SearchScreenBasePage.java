package com.shopping.demo.pages.AddToCart;

import java.io.IOException;

import com.shopping.demo.utils.UtilFunctions;

public abstract class SearchScreenBasePage extends UtilFunctions implements SearchScreenPage{
	
	public abstract String addFirstItemToCart() throws IOException;
	
	public abstract void checkItemAddedToCart() throws IOException;
	
	public abstract void addRandomItemToCart() throws IOException;

	public abstract void checkItemDescriptionDisplayed() throws IOException;
	
	public abstract void searchForItem(String itemToBeSearched) throws IOException;
	
	public abstract void compareItemCheckOutDetails() throws IOException;
}
