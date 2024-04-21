package stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.base.TestBase;
import com.pages.AccountPage;
import com.pages.HomePage;
import com.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	TestBase tBase=new TestBase();
	
	@Given("User has navigates to Login Page")
	public void User_has_navigates_to_Login_Page() {
		driver=TestBase.getDriver();
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage=homePage.selectLoginOption();
	}

	@When("^User enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String emailText) {

		loginPage.enterEmailAddress(emailText);
	}

	@And("^User has entered valid password (.+) into password field$")
	public void user_has_entered_valid_password_into_password_field(String passwordText) {
   
		loginPage.enterPasswordAddress(passwordText);
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {

		accountPage=loginPage.clickOnLoginBtn();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {

		Assert.assertTrue(accountPage.displayStatusOfEditAccountInfoOption());
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		
		loginPage.enterEmailAddress(tBase.getEmailTimeStamp());
	}

	@And("User has entered invalid password {string} into password field")
	public void user_has_entered_invalid_password_into_password_field(String invalidPasswordText) {

		loginPage.enterPasswordAddress(invalidPasswordText);
		
	}

	@Then("User should get a proper warning message about credentails mismatch")
	public void user_should_get_a_proper_warning_message_about_credentails_mismatch() {
		
		
		Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
		
		
		loginPage.enterEmailAddress("");
		
	}

	@And("User dont entere password into password field")
	public void user_dont_entere_password_into_password_field() {
		loginPage.enterPasswordAddress("");
	}

}
