package com.shopping.demo.StepDefinition;

import java.io.IOException;

import com.shopping.demo.pages.AddToCart.SearchScreenBasePage;
import com.shopping.demo.pages.AddToCart.SearchScreenPageAndroid;
import com.shopping.demo.pages.CheckOut.CartCheckoutAndroid;
import com.shopping.demo.pages.CheckOut.CartCheckoutBase;
import com.shopping.demo.pages.Login.LoginBasePage;
import com.shopping.demo.pages.Login.LoginPageAndroid;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class common {
	
	LoginBasePage LoginPage = new LoginPageAndroid();
	SearchScreenBasePage homePage = new SearchScreenPageAndroid();
	CartCheckoutBase checkOut = new CartCheckoutAndroid();
	
	/*--------
	This method logs into the application
	NoParams Required
	----------*/
	@Given("User logs into the application")
	public void Login() throws IOException {
		LoginPage.login();
	}
	
	/*--------
	This method logs into the application
	Requires portrait or landscape view
	----------*/
	@Given("^User logs into the application in \"([^\"]*)\" mode$")
    public void loginWithMode(String mode) throws Throwable {
        LoginPage.login(mode);
    }
	
	/*--------
	This method searches for an random item from the list
	Input the string to be searched for
	----------*/
	@When("^User searches for a random \"([^\"]*)\"$")
	public void searchForIteam(String item) throws IOException {
		homePage.searchForItem(item);
	}

	/*--------
	This method adds first item to cart
	NoParams Required
	----------*/
	@When("User clicks on add to cart for the first item displayed")
	public void clicksOnFirstElement() throws IOException {
		homePage.addFirstItemToCart();
	}

	/*--------
	This method verifies the first item added displays in cart
	NoParams Required
	----------*/
	@Then("^Verify the item is displayed with the first item in the cart$")
	public void verifyItemDisplayed() throws IOException {
		homePage.checkItemAddedToCart();
	}
	
	/*--------
	This method verifies all details are there in cart added
	NoParams Required
	----------*/
	@Then("^Verify the item is displayed with the added item in the cart with all details")
	    public void verifyItemWithDetails() throws Throwable {
		homePage.checkItemDescriptionDisplayed();
	    }
	
	/*--------
	This method compares the items in list with added cart details
	NoParams Required
	----------*/
	 @Then("^Verify the item is displayed with the added item in the cart are same as the details from the list$")
	    public void compareItemDetails() throws Throwable {
		 homePage.compareItemCheckOutDetails();
	    }
	 
	 /*--------
	This method does checkout
	NoParams Required
	----------*/
	 @And("^Check Out the item$")
	    public void checkOut() throws Throwable {
		 checkOut.checkOut();
	    }

	 /*--------
	This method add random item from list to cart
	NoParams Required
	----------*/
	@And("^User adds a random item displayed in the list$")
	    public void addRandomItemToCart() throws Throwable {
		homePage.addRandomItemToCart();
	    }

}
