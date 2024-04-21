package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.ElementUtils;

public class LoginPage {
	
    WebDriver driver;
	private ElementUtils elementUtils;
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(id ="input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginbtn;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	public void enterEmailAddress(String emailText) {
		elementUtils.typeTextIntoElement(emailField, emailText, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	public void enterPasswordAddress(String passwordText) {
		elementUtils.typeTextIntoElement(passwordField, passwordText, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public AccountPage clickOnLoginBtn() {
		elementUtils.clickOnElement(loginbtn, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountPage(driver);
	}
	
	public String getWarningMessageText() {
		
		return elementUtils.getTextFromElement(warningMessage, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
