
package com.shopping.demo.pages.AddToCart;

import java.io.IOException;

public interface SearchScreenPage {
	
	public String addFirstItemToCart() throws IOException;
	
	public void searchForItem(String itemToBeSearched) throws IOException;
	
	public void checkItemAddedToCart() throws IOException;
	
	public void addRandomItemToCart() throws IOException;

	public void checkItemDescriptionDisplayed() throws IOException;
	
	public void compareItemCheckOutDetails() throws IOException;

}
