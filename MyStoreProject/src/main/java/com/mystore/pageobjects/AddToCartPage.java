package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {

	@FindBy(id = "quantity_wanted")
	WebElement quantity;

	@FindBy(name = "group_1")
	WebElement size;

	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement addToCartBtn;

	@FindBy(xpath = "//*[@id='layer_cart']//h2/i")
	WebElement addToCartMessage;

	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutBtn;

	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterQuantity(String quant) {
		Action.type(quantity, quant);
	}

	public void selectSize(String size1) {
		Action.selectByVisibleText(size1, size);
	}

	public void clickOnAddToCart() {
		Action.click(driver, addToCartBtn);
	}

	public boolean validateAddToCart() {
		Action.explicitWait(driver, addToCartMessage, 10);
		return Action.isDisplayed(driver, addToCartMessage);
	}

	public OrderPage clickOnCheckout() throws Exception {
		Action.fluentWait(driver, proceedToCheckOutBtn, 10);
		Action.JSClick(driver, proceedToCheckOutBtn);
		Action.fluentWait(driver, proceedToCheckOutBtn, 10);
		return new OrderPage();
	}
}
