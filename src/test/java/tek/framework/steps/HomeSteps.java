package tek.framework.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.framework.pages.POMFactory;
import tek.framework.utilites.CommonUtility;

public class HomeSteps extends CommonUtility {
	POMFactory factory = new POMFactory();
//---------------Verify Shop by Department sidebar
	
	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.homepage().allSectionBtn);
		logger.info("User clicked on All Section");
	}

	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
		// List<List<String>> departmentSection = dataTable.asLists(String.class);
		List<WebElement> dept = factory.homepage().sidebar;
		for (WebElement element : dept) {
			if (element.getText().equals(dataTable)) {
				element.click();
				Assert.assertTrue(element.isDisplayed());
				break;
			}
			logger.info("The departments are present");
		}
	}
//---------------Verify department sidebar options
	
	@And("User on {string}")
	public void userOnDepartment(String department) {
		List<WebElement> dept = factory.homepage().sidebar;
		for (WebElement element : dept) {
			if (element.getText().equals(department)) {
				element.click();
				break;
			}
		}

	}

	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {
		List<List<String>> departmentSection = dataTable.asLists(String.class);
		List<WebElement> dept = factory.homepage().sidebar;
		for (int i = 0; i < departmentSection.get(0).size(); i++) {
			for (WebElement element : dept) {
				if (element.getText().equals(departmentSection.get(0).get(i))) {
					Assert.assertTrue(element.isDisplayed());
					logger.info(element.getText() + "The items is present");
				}
			}
		}
	}
//--------------Verify User can add an item to cart

	@When("User change the category to {string}")
	public void userChangeTheCategoryTo(String string) {
		selectByVisibleText(factory.homepage().allCategory, string);
		logger.info("User changed the category");
	}

	@When("User search for an item {string}")
	public void userSearchForAnItem(String string) {
		sendText(factory.homepage().searchBarInput, string);
		logger.info("User searched for item");
	}

	@When("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(factory.homepage().searchButton);
		logger.info("User clicked on search icon");
	}

	@When("User click on item")
	public void userClickOnItem() {
		click(factory.homepage().itemToAdd);
		logger.info("User click on item");
	}

	@When("User select quantity {string}")
	public void userSelectQuantity(String int1) {
		selectByVisibleText(factory.homepage().qty, int1);
		logger.info("User selected quantity");
	}

	@When("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(factory.homepage().addToCart);
		logger.info("User clicked add to Cart button");
	}

	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String int2) {
		Assert.assertTrue(isElementDisplayed(factory.homepage().cartQty));
		logger.info("the cart icon quantity changed");
	}

//------------Verify User can place an order without address
	
	@And("User click on Cart option")
	public void userClickOnCartOption() {
		click(factory.homepage().addToCartBtn);
		click(factory.homepage().cartQty);
		logger.info("User clicked on Cart option");
	}

	@And("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		click(factory.homepage().proceedToCheckoutBtn);
		logger.info("user clicked on proceed to checkout button");
	}

	@And("User click Add a new address link for shipping address")
	public void userClickAddANewAddressLinkForShippingAddress() {
		click(factory.homepage().addAddressLink);
		logger.info("User clicked add address Link");
	}

	@And("User click Add a credit card or Debit Card for Payment method")
	public void userClickAddACreditCardOrDebitCardForPaymentMethod() {
		scrollPageDownWithJS();
//	waitTillClickable(factory.homepage().addCreditBtn);
		click(factory.homepage().addCreditBtn);
		logger.info("User clicked Add a credit card or Debit Card");
	}

	@And("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		click(factory.homepage().placeOrderBtn);
		logger.info("User clicked on Place Your Order");
	}

	@Then("a message Should be displayed {string}")
	public void aMessageShouldBeDisplayedOrderPlacedThanks(String string) {
		waitTillPresence(factory.homepage().orderMessage);
		Assert.assertTrue(isElementDisplayed(factory.homepage().orderMessage));
		String accualMessage = factory.homepage().orderMessage.getText();
		String expectedMessage = "Order Placed Successfully";
		Assert.assertEquals(accualMessage, expectedMessage);
		logger.info("order placed");
	}
	
//-----------------Verify User can place an order with Shipping address

	@When("User click on Item")
	public void userClickOnItem1() {
		click(factory.homepage().apexItem);
		logger.info("item clicked");
	}

	@Then("a message should be Displayed {string}")
	public void aMessageShouldBeDisplayed(String string) {
		waitTillPresence(factory.homepage().orderMessage);
		Assert.assertTrue(isElementDisplayed(factory.homepage().orderMessage));
		String accualMessage = factory.homepage().orderMessage.getText();
		String expectedMessage = "Order Placed Successfully";
		Assert.assertEquals(accualMessage, expectedMessage);
		logger.info("order placed successfully");

	}
}