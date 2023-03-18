package tek.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.framework.pages.POMFactory;
import tek.framework.utilites.CommonUtility;

public class RetailAccountSteps extends CommonUtility {
	POMFactory factory = new POMFactory();

//------------------Verify User can Update profile
	
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

		waitTillPresence(factory.accountPage().updateMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().updateMessage));
		String acctualMessage = factory.accountPage().updateMessage.getText();
		String expectedMessage = "Personal Information Updated Successfully";
		Assert.assertEquals(expectedMessage, acctualMessage);
		logger.info("User profile information updated");
	}

	// ---------------Verify User can Update password
	
	@And("User enter below information")
	public void userEnterBelowInformation(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().previousPasswordField, data.get(0).get("previousPassword"));
		sendText(factory.accountPage().newPasswordField, data.get(0).get("newPassword"));
		sendText(factory.accountPage().confirmPasswordField, data.get(0).get("confirmPassword"));
		logger.info("User entered new password");
	}

	@And("User click on Change Password button")
	public void userClickOnChangePasswordButton() {
		click(factory.accountPage().changePasswordBtn);
		logger.info("User clicked on Change Password button");

	}

	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String passwordMessage) {
		String message = "Password Updated Successfully";
		String result = getElementText(factory.accountPage().updatedPasswordMessage);
		logger.info("Update password message is displayed");
	}

	// ------------Verify User can add a payment method
	
	@And("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(factory.accountPage().addPaymentLink);
		logger.info("User click on Add a payment method link");
	}

	@And("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable1) {
		List<Map<String, String>> data1 = dataTable1.asMaps(String.class, String.class);
		sendText(factory.accountPage().cardNumberField, data1.get(0).get("cardNumber"));
		sendText(factory.accountPage().nameOnCardField, data1.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().expirationMonthField, data1.get(0).get("expirationMonth"));
		selectByVisibleText(factory.accountPage().expirationYearField, data1.get(0).get("expirationYear"));
		sendText(factory.accountPage().securityCodeField, data1.get(0).get("securityCode"));
		logger.info("User entered card information");
	}

	@And("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(factory.accountPage().addCardBtn);
		logger.info("User click on Add your card button");
	}

	@Then("message should be displayed {string}")
	public void MessageShouldBeDisplayed(String paymentMessage) {
		String message = "Payment Method added sucessfully";
		String result = getElementText(factory.accountPage().paymentMethodMessage);
		Assert.assertEquals(message, result);
		logger.info("payment method added");
	}

	// -----------Verify User can edit Payment method
	
	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(factory.accountPage().card);
		click(factory.accountPage().editBtn);
	}

	@When("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable3) {
		List<Map<String, String>> data1 = dataTable3.asMaps(String.class, String.class);
		factory.accountPage().cardNumberField.clear();
		sendText(factory.accountPage().cardNumberField, data1.get(0).get("cardNumber"));
		factory.accountPage().nameOnCardField.clear();
		sendText(factory.accountPage().nameOnCardField, data1.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().expirationMonthField, data1.get(0).get("expirationMonth"));
		selectByVisibleText(factory.accountPage().expirationYearField, data1.get(0).get("expirationYear"));
		factory.accountPage().securityCodeField.clear();
		sendText(factory.accountPage().securityCodeField, data1.get(0).get("securityCode"));
		logger.info("User entered  new card information");
	}

	@When("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(factory.accountPage().UpdateCardBtn);
	}

	@Then("A message should be displayed {string}")
	public void aMessageShouldBeDisplayedPaymentMethodUpdatedSuccessfully(String message) {
		String paymentMessage = "Payment Method updated Successfully";
		String result = getElementText(factory.accountPage().updateCardMessage);
		Assert.assertEquals(paymentMessage, result);
		logger.info("payment method updated");
	}

	// ----------Verify User can remove Payment method
	
	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(factory.accountPage().card);
		click(factory.accountPage().removeCardBtn);
		logger.info("User clicked on remove option");
	}

	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		Assert.assertTrue(isElementDisplayed(factory.accountPage().addPaymentLink));
		logger.info("payment details removed");
	}

	// -----------------Verify User can add an Address
	
	@And("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(factory.accountPage().addAddress);
		logger.info("User clicked on Add address option");
	}

	@And("user fill address form with below information")
	public void userFillAddressFormWithBelowInformation(DataTable dataTable3) {
		List<Map<String, String>> data3 = dataTable3.asMaps(String.class, String.class);
		selectByVisibleText(factory.accountPage().countryDropdown, data3.get(0).get("country"));
		sendText(factory.accountPage().fullName, data3.get(0).get("fullName"));
		sendText(factory.accountPage().phoneNumber, data3.get(0).get("phoneNumber"));
		sendText(factory.accountPage().street, data3.get(0).get("streetAddress"));
		sendText(factory.accountPage().apt, data3.get(0).get("apt"));
		sendText(factory.accountPage().city, data3.get(0).get("city"));
		selectByVisibleText(factory.accountPage().state, data3.get(0).get("state"));
		sendText(factory.accountPage().zip, data3.get(0).get("zipCode"));
		logger.info("user filled address form");

	}

	@And("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(factory.accountPage().addressBtn);
		logger.info("User clicked Add Your Address button");
	}

	@Then("a Message should be displayed {string}")
	public void aMessageShouldBeDisplayedAddressAddedSuccessfully(String AddressMessage) {
		String addressMessage = "Address Added Successfully";
		String text = getElementText(factory.accountPage().addressMessage);
		Assert.assertEquals(addressMessage, text);
		logger.info("Address Added");
	}

	// -----------------Verify User can edit Address
	
	@And("User click on edit address option")
	public void userClickOnEditAddressOption() {
		click(factory.accountPage().editAddressBtn);
		logger.info("User clicked on edit address button");
	}

	@And("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable4) {
		List<Map<String, String>> data3 = dataTable4.asMaps(String.class, String.class);
		selectByVisibleText(factory.accountPage().countryDropdown, data3.get(0).get("country"));
		clearTextUsingSendKeys(factory.accountPage().fullName);
		sendText(factory.accountPage().fullName, data3.get(0).get("fullName"));
		clearTextUsingSendKeys(factory.accountPage().phoneNumber);
		sendText(factory.accountPage().phoneNumber, data3.get(0).get("phoneNumber"));
		clearTextUsingSendKeys(factory.accountPage().street);
		sendText(factory.accountPage().street, data3.get(0).get("streetAddress"));
		clearTextUsingSendKeys(factory.accountPage().apt);
		sendText(factory.accountPage().apt, data3.get(0).get("apt"));
		clearTextUsingSendKeys(factory.accountPage().city);
		sendText(factory.accountPage().city, data3.get(0).get("city"));
		selectByVisibleText(factory.accountPage().state, data3.get(0).get("state"));
		clearTextUsingSendKeys(factory.accountPage().zip);
		sendText(factory.accountPage().zip, data3.get(0).get("zipCode"));
		logger.info("User fill new address form");
	}

	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		click(factory.accountPage().updateAddressBtn);
		logger.info("User clicked update Your Address button");
	}

	@Then("a message should be displayed. {string}")
	public void updatedAddressAddedSuccessfully(String editAddressMessage) {
		String updateAddressMessage = "Address Updated Successfully";
		String text = getElementText(factory.accountPage().updatedAddressMessage);
		Assert.assertEquals(updateAddressMessage, text);
		logger.info("Address updated");
	}

	//------------------ Verify User can remove Address
	
	@When("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		click(factory.accountPage().removeAddressBtn);
		logger.info("User clicked on remove option of address section");
	}

	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		Assert.assertTrue(isElementDisplayed(factory.accountPage().editAddressBtn));
	}
}
