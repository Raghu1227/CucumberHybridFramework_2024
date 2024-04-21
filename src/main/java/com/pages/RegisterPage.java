package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameFiled;

	@FindBy(id = "input-lastname")
	private WebElement lastnameFiled;

	@FindBy(id = "input-email")
	private WebElement emailFiled;

	@FindBy(id = "input-telephone")
	private WebElement telephoneFiled;

	@FindBy(id = "input-password")
	private WebElement passwordFiled;

	@FindBy(id = "input-confirm")
	private WebElement confirmpasswordFiled;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicyOption;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement clickOnContinueBtn;
	
	@FindBy(css = "input[value='1'][name='newsletter']")
	private WebElement selectNewslettercheckBox;
	
	@FindBy( xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarningMessage;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarningMessage;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarningMessage;
	
	
	public void enterFirstName(String firstNameText) {

		elementUtils.typeTextIntoElement(firstNameFiled, firstNameText, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterLastName(String lastNameText) {
		elementUtils.typeTextIntoElement(lastnameFiled, lastNameText, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enteEmail(String emailText) {
        elementUtils.typeTextIntoElement(emailFiled, emailText, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterTelephoneNumber(String telephoneNumber) {
        elementUtils.typeTextIntoElement(telephoneFiled, telephoneNumber, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterPassword(String PasswordText) {
        elementUtils.typeTextIntoElement(passwordFiled, PasswordText, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterConfirmPassword(String PasswordText) {
        elementUtils.typeTextIntoElement(confirmpasswordFiled, PasswordText, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void clickOnPrivacyPolicycheckbox() {
        elementUtils.clickOnElement(privacyPolicyOption, elementUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public AccountSucessPage clickOnContinueBtn() {

		elementUtils.clickOnElement(clickOnContinueBtn, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountSucessPage(driver);

	}
	
	public void clickOnNewslettrCheckBox() {
		elementUtils.clickOnElement(selectNewslettercheckBox, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getWarningMessageText() {
		return elementUtils.getTextFromElement(warningMessage, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	public String getFirstNameMessageText() {
		return elementUtils.getTextFromElement(firstNameWarningMessage, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getLastNameMessageText() {
		return elementUtils.getTextFromElement(lastNameWarningMessage, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getEmailMessageText() {
		return elementUtils.getTextFromElement(emailWarningMessage, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getTelephoneMessageText() {
		return elementUtils.getTextFromElement(telephoneWarningMessage, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getPasswordMessageText() {
		return elementUtils.getTextFromElement(passwordWarningMessage, elementUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
