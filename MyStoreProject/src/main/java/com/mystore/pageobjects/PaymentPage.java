package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {

	@FindBy(css = "a[title='Pay by bank wire']")
	WebElement bankWireMethod;

	@FindBy(xpath = "//a[contains(text(),'Pay by check']")
	WebElement payByCheckMethod;

	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}

	public OrderSummary clickOnPaymentMethod() {
		Action.click(driver, bankWireMethod);
		return new OrderSummary();
	}

}
