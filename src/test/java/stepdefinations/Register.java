package stepdefinations;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.base.TestBase;
import com.pages.AccountSucessPage;
import com.pages.HomePage;
import com.pages.RegisterPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {
	
	WebDriver driver;
	
	private RegisterPage registerPage;
	private AccountSucessPage accountSuccessPage;
	
	TestBase tBase=new TestBase();

	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
	   
		driver=TestBase.getDriver();
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage=homePage.selectRegisterOption();
		
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(io.cucumber.datatable.DataTable dataTable) {
				
		Map<String,String> dataMap=dataTable.asMap(String.class,String.class);
		
		registerPage.enterFirstName(dataMap.get("firstname"));
		registerPage.enterLastName(dataMap.get("lastname"));
		registerPage.enteEmail(tBase.getEmailTimeStamp());
		registerPage.enterTelephoneNumber(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
	}
	
	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(io.cucumber.datatable.DataTable dataTable) {
				
		Map<String,String> dataMap=dataTable.asMap(String.class,String.class);
		
		registerPage.enterFirstName(dataMap.get("firstname"));
		registerPage.enterLastName(dataMap.get("lastname"));
		registerPage.enteEmail(dataMap.get("email"));
		registerPage.enterTelephoneNumber(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
		
	}

	@And("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
	   
		registerPage.clickOnPrivacyPolicycheckbox();
	}

	@And("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
	   
		accountSuccessPage=registerPage.clickOnContinueBtn();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		
		Assert.assertTrue(accountSuccessPage.getPageHeading().contains("Your Account Has Been Created!"));
		
	}

	@And("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
	   
		registerPage.clickOnNewslettrCheckBox();
	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
	    
		Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
	   
		registerPage=new RegisterPage(driver);
	}

	@Then("User should get proper warning message for every mandatory field")
	public void user_should_get_proper_warning_message_for_every_mandatory_field() {
		Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!",registerPage.getFirstNameMessageText());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerPage.getLastNameMessageText());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",registerPage.getEmailMessageText());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerPage.getTelephoneMessageText());
		Assert.assertEquals("Password must be between 4 and 20 characters!",registerPage.getPasswordMessageText());
		
	}
		
}
