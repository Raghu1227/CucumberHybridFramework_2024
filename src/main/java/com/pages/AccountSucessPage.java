package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.ElementUtils;

public class AccountSucessPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public AccountSucessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(css ="div[id='content'] h1")
	private WebElement pageHeading;
	
	public String getPageHeading() {
		return elementUtils.getTextFromElement(pageHeading, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
