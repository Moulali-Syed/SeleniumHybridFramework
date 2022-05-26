package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass {

	IndexPage index;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;

	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test
	public void addToCartTest() {
		index = new IndexPage();
		searchResultPage = index.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		boolean result = addToCartPage.validateAddToCart();
		Assert.assertTrue(result);
	}
}
