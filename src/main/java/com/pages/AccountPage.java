package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.ElementUtils;

public class AccountPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	@FindBy(linkText ="Edit your account information")
	private WebElement editYourAccountInfo;
	
	public boolean displayStatusOfEditAccountInfoOption() {
		return elementUtils.displayStatusOfElement(editYourAccountInfo, elementUtils.IMPLICIT_WAIT_TIME);
	}
}
