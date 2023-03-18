package tek.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.framework.utilites.CommonUtility;
import tek.framework.utilites.DataGenerator;
import tek.framework.pages.POMFactory;

public class SignInSteps extends CommonUtility {

	POMFactory factory = new POMFactory();
//--------------Verify user can sign in
	
	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String actualTitle = getTitle();
		String expectedTitle = "React App";
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertTrue(isElementDisplayed(factory.homepage().tekschoollogo));
	}

	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
		click(factory.homepage().signInOption);
		logger.info("user click on sign in option");
	}

	@And("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String emailValue, String passValue) {
		sendText(factory.SignInPage().emailInput, emailValue);
		sendText(factory.SignInPage().passwordInput, passValue);
		logger.info("user entered email and password");
	}

	@And("User click on login button")
	public void userClickOnLoginButton() {
		click(factory.SignInPage().loginBtn);
		logger.info("user clicked on login button");
	}

	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
		Assert.assertTrue(isElementDisplayed(factory.homepage().accountOption));
		logger.info("user is logged in into Account");
	}
//-----------------Verify user can create an account
	
	@When("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(factory.SignInPage().createAccountBtn);
		logger.info("User clicked on Create New Account button");
	}

	@When("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		sendText(factory.SignInPage().nameField,DataGenerator.getData(data.get(0).get("name")));
		sendText(factory.SignInPage().emailField,DataGenerator.getData(data.get(0).get("email")));
		sendText(factory.SignInPage().passwordField, data.get(0).get("password"));
		sendText(factory.SignInPage().confirmPasswordField, data.get(0).get("confirmPassword"));
		logger.info("User filled the signUp information form");
	}

	@When("User click on signUp button")
	public void userClickOnSignUpButton() {
		click(factory.SignInPage().signUpBtn);
		logger.info("User click on signUp button");
	}

	@Then("User should be logged into Account page")
	public void userShouldBeLoggedIntoAccountPage() {
		waitTillPresence(factory.accountPage().logoutBtn);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().logoutBtn));
		logger.info("user is logged into account page");
	}
}
