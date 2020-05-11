package com.shopping.demo.pages.AddToCart;

import java.io.IOException;

import org.testng.Assert;

import com.shopping.demo.Resources.TestConstants.TestConstants;
import com.shopping.demo.utils.Excel_reader;

public class SearchScreenPageAndroid extends SearchScreenBasePage implements SearchScreenPage {

	Excel_reader excel = new Excel_reader();
	public String itemNameAdded, itemPrice, itemDescription;
	
	@Override
	public void searchForItem(String itemToBeSearched) throws IOException {
		clickElement(TestConstants.SEARCH_SCREEN_ITEM_TEXT_FIELD);
		inputString(TestConstants.SEARCH_SCREEN_ITEM_TEXT_FIELD, itemToBeSearched);
		clickElement(TestConstants.SEARCH_SCREEN_SEARCH_BUTTON);
		
	}
	
	@Override
	public String addFirstItemToCart() throws IOException {
		itemNameAdded = getAttribute(TestConstants.SEARCH_FIRST_ELEMENT_LABEL, "text").toString();
		clickElement(TestConstants.SEARCH_SCREEN_ADDTOCART_ICON);
		return itemNameAdded;
	}

	@Override
	public void checkItemAddedToCart() throws IOException {
		clickElement(TestConstants.CART_SCREEN_ADDTOCART_ICON_BUTTON);
		Assert.assertTrue(isVisible(TestConstants.CART_SCREEN_CHECK_ITEMS));
		String itemName = getElements(TestConstants.CART_SCREEN_CHECK_ITEMS).get(0).getText();
		Assert.assertEquals(itemName, itemNameAdded);
	}

	@Override
	public void addRandomItemToCart() throws IOException {
		// TODO Auto-generated method stub
		for(int i=0; i<getElements(TestConstants.SEARCH_SCREEN_ALL_ELEMENTS).size();i++){
			if(getElementText(getElements(TestConstants.SEARCH_SCREEN_ALL_ELEMENTS).get(i).getText())
					.contains(excel
							.getDataWithColumnName(TestConstants.EXCEL_DATA_WORKBOOK,
									TestConstants.EXCEL_TEST_DATA_SHEET, "ITEMDESCRIPTION"))){
				itemNameAdded = getElementText(getElements(TestConstants.SEARCH_SCREEN_ALL_ELEMENTS).get(i).getText());
				itemPrice = getElementText(getElements(TestConstants.SEARCH_SCREEN_ELEMENT_PRICE).get(i).getText());
				itemDescription = getElementText(getElements(TestConstants.SEARCH_SCREEN_ELEMENT_DESCRIPTION).get(i).getText());
				getElements(TestConstants.SEARCH_SCREEN_ADDTOCART_ICON).get(i).click();
				break;
			}
		}
	}

	@Override
	public void checkItemDescriptionDisplayed() throws IOException {
		// TODO Auto-generated method stub
		clickElement(TestConstants.CART_SCREEN_ADDTOCART_ICON_BUTTON);
		Assert.assertTrue(isVisible(TestConstants.CART_SCREEN_CHECK_ITEMS));
		for(int i=0; i<getElements(TestConstants.CART_SCREEN_CHECK_ITEMS).size();i++){
		Assert.assertTrue(getElements(TestConstants.CART_SCREEN_CHECK_ITEM_NAME).get(i).isDisplayed());
		Assert.assertTrue(getElements(TestConstants.CART_SCREEN_CHECK_ITEM_PRICE).get(i).isDisplayed());
		Assert.assertTrue(getElements(TestConstants.CART_SCREEN_CHECK_ITEM_DESCRIPTION).get(i).isDisplayed());
		}
		}


	@Override
	public void compareItemCheckOutDetails() throws IOException {
		clickElement(TestConstants.CART_SCREEN_ADDTOCART_ICON_BUTTON);
		Assert.assertTrue(isVisible(TestConstants.CART_SCREEN_CHECK_ITEMS));
		for(int i=0; i<getElements(TestConstants.CART_SCREEN_CHECK_ITEMS).size();i++){
			if(getElements(TestConstants.CART_SCREEN_CHECK_ITEM_DESCRIPTION).get(i).getText()
					.contains(excel
							.getDataWithColumnName(TestConstants.EXCEL_DATA_WORKBOOK,
									TestConstants.EXCEL_TEST_DATA_SHEET, "ITEMDESCRIPTION"))){
				Assert.assertEquals(itemNameAdded, getElements(TestConstants.CART_SCREEN_CHECK_ITEM_NAME).get(i).getText());
				Assert.assertEquals(itemPrice, getElements(TestConstants.CART_SCREEN_CHECK_ITEM_PRICE).get(i).getText());
				Assert.assertEquals(itemDescription, getElements(TestConstants.CART_SCREEN_CHECK_ITEM_DESCRIPTION).get(i).getText());
			}
	}
	}

}
