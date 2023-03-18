package tek.framework.steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.framework.pages.POMFactory;
import tek.framework.utilites.CommonUtility;

public class RetailOrderSteps extends CommonUtility{
	POMFactory factory = new POMFactory();
	
	//------------Verify User can cancel the order
	@And("User click on Orders section")
	public void userClickOnOrdersSection() {
	   click(factory.orderPage().orderLink);
	   logger.info("User clicked on Orders section");
	}
	@And("User click on first order in list")
	public void userClickOnFirstOrderInList() {
	   // click(factory.orderPage().showDetails);
	    click(factory.orderPage().HideDetails);
	    click(factory.orderPage().showDetails);
	    logger.info("User clicked on first order in list");
	}
	@And("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
	    click(factory.orderPage().cancelOrderBtn);
	    logger.info("User clicked on Cancel The Order button");
	}
	@And("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReason(String string) {
		selectByVisibleText(factory.orderPage().cancelationReason, string);
	}
	@And("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
	    click(factory.orderPage().cancelOrder);
	}
	@Then("a cancelation message should be displayed {string}")
	public void aCancelationMessageShouldBeDisplayed(String string) {
		Assert.assertTrue(isElementDisplayed(factory.orderPage().cancelationMessage));
		String acctualMessage = factory.orderPage().cancelationMessage.getText();
		   String expectedMessage = "Your Order Has Been Cancelled";
		   Assert.assertEquals(expectedMessage, acctualMessage);
		   logger.info("cancelation message displayed");
	}
	//-----------Verify User can Return the order
	
	@When("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
	    click(factory.orderPage().returnItemBtn);
	    logger.info("User clicked on Return button");
	}
	
	@When("User select the Return Reason {string}")
	public void userSelectTheReturnReasonItemDamaged(String string) {
	    selectByVisibleText(factory.orderPage().returnReason,string);
	    logger.info("User selected the Return Reason");
	}
	
	@When("User select the drop off service {string}")
	public void userSelectTheDropOffServiceFedEx(String string) {
		selectByVisibleText(factory.orderPage().dropOff,string);
		logger.info("User selected the drop off service");
	}
	
	@When("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
	    click(factory.orderPage().returnBtn);
	    logger.info("User clicked on Return Order button");
	}
	
	@Then("a confirmation message should be displayed {string}")
	public void aConfirmationMessageShouldBeDisplayedReturnWasSuccessful(String string) {
		Assert.assertTrue(isElementDisplayed(factory.orderPage().returnMessage));
		String acctualMessage = factory.orderPage().returnMessage.getText();
		   String expectedMessage = "Return was successfull";
		   Assert.assertEquals(expectedMessage, acctualMessage);
		   logger.info("confirmation message displayed");
	}
	//------------Verify User can write a review
	
	@When("User click on Review button")
	public void userClickOnReviewButton() {
	    click(factory.orderPage().reviewBtn);
	    logger.info("User clicked on Review button");
	}
	
	@When("User write Review headline {string} and {string}")
	public void userWriteReviewHeadlineAnd(String title, String review) {
	    sendText(factory.orderPage().headline,title);
	    sendText(factory.orderPage().description,review);
	    logger.info("User filled Review headline");
	}
	
	@When("User click Add your Review button")
	public void userClickAddYourReviewButton() {
	    click(factory.orderPage().reviewSubmitBtn);
	    logger.info("User clicked Add your Review button");
	}
	
	@Then("a review message should be displayed {string}")
	public void aReviewMessageShouldBeDisplayed(String string) {
		waitTillPresence(factory.orderPage().reviewMessage);
		Assert.assertTrue(isElementDisplayed(factory.orderPage().reviewMessage));
		String acctualMessage = factory.orderPage().reviewMessage.getText();
		   String expectedMessage = "Your review was added successfully";
		   Assert.assertEquals(expectedMessage, acctualMessage);
		   logger.info("review message displayed");
	}
}
