package tek.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.framework.pages.POMFactory;
import tek.framework.utilites.CommonUtility;

public class RetailAccountSteps extends CommonUtility{
	POMFactory factory = new POMFactory();
	
	@When("User click on Account option")
	public void userClickOnAccountOption() {
	    click(factory.homepage().accountOption);
	    logger.info("User clicked on Account option");
	}
	@And("User Update name {string} and phone {string}")
	public void userUpdateNameAndPhone(String nameValue, String phoneValue) {
		factory.accountPage().nameField.clear();
	    sendText(factory.accountPage().nameField, nameValue);
	    factory.accountPage().phoneNumberField.clear();
	    sendText(factory.accountPage().phoneNumberField, phoneValue);
	    logger.info("User entered personal information");
	}
	@And("User click on Update button")
	public void userClickOnUpdateButton() {
		click(factory.accountPage().updateBtn);
		logger.info("User clicked on Update button");
	   
	}
	@Then("User profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		
		Assert.assertTrue(isElementDisplayed(factory.accountPage().name));
		logger.info("User profile information updated");
	   
	}
	@And("User enter below information")
	public void userEnterBelowInformation(DataTable dataTable) {
		List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().previousPasswordField,data.get(0).get("previousPassword"));
		sendText(factory.accountPage().newPasswordField,data.get(0).get("newPassword"));
		sendText(factory.accountPage().confirmPasswordField,data.get(0).get("confirmPassword"));
		logger.info("User entered new password");
	}
	@And("User click on Change Password button")
	public void userClickOnChangePasswordButton() {
		click(factory.accountPage().changePasswordBtn);
		logger.info("User clicked on Change Password button");
		
	}
	
	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed() {
		Assert.assertTrue(isElementDisplayed(factory.accountPage().updatedPasswordMessage));
		logger.info("Update password message is displayed");	
	}
	
	@And("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
	    click(factory.accountPage().addPaymentLink);
	    logger.info("User click on Add a payment method link");
	}
	@And("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable1) {
		List<Map<String, String>> data1 = dataTable1.asMaps(String.class, String.class);
		sendText(factory.accountPage().cardNumberField,data1.get(0).get("cardNumber"));
		sendText(factory.accountPage().nameOnCardField,data1.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().expirationMonthField,data1.get(0).get("expirationMonth"));
		selectByVisibleText(factory.accountPage().expirationYearField,data1.get(0).get("expirationYear"));
		sendText(factory.accountPage().securityCodeField,data1.get(0).get("securityCode"));
		logger.info("User entered card information");
	}
	@And("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
	    click(factory.accountPage().addCardBtn);
	    logger.info("User click on Add your card button");
	}
	
	@Then("message should be displayed {string}")
	public void MessageShouldBeDisplayed(String paymentMessage) {
		//Assert.assertTrue(isElementDisplayed(factory.accountPage().paymentMethodMessage));
		String message ="Payment Method added sucessfully";
		String result = getElementText(factory.accountPage().paymentMethodMessage);
		Assert.assertEquals(message, result);
		logger.info("payment method added");
	}
	
	
	
	}
