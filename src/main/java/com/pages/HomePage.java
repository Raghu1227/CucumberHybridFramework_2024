package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(css = "input[placeholder='Search']")
	private WebElement searchBoxField;
	
	@FindBy(css = "button[class='btn btn-default btn-lg']")
	private WebElement SearchBtn;
	
	public void clickOnMyAccount() {
		elementUtils.clickOnElement(myAccountDropMenu, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	public LoginPage selectLoginOption() {
		elementUtils.clickOnElement(loginOption, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
	}
	public RegisterPage selectRegisterOption() {
		elementUtils.clickOnElement(registerOption, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);
	}
	
	public void enterSearchBoxFiled(String productName) {
		
		elementUtils.typeTextIntoElement(searchBoxField, productName, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public SearchResultsPage clickOnSearchBtn() {
		
		elementUtils.clickOnElement(SearchBtn, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new SearchResultsPage(driver);
	}
	
}
