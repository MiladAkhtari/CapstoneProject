package tek.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.framework.base.BaseSetup;

public class RetailOrderPage extends BaseSetup{
public RetailOrderPage() {
	PageFactory.initElements(getDriver(), this);
}
@FindBy(id = "orderLink") public WebElement orderLink;

@FindBy(xpath="//p[contains(text(),'Show Details')]") public WebElement showDetails;

@FindBy(xpath = "//p[contains(text(),'Hide Details')]")public WebElement HideDetails;

@FindBy(id = "cancelBtn") public WebElement cancelOrderBtn;

@FindBy(id = "reasonInput") public WebElement cancelationReason;

@FindBy(id = "orderSubmitBtn") public WebElement cancelOrder;

@FindBy(xpath = "//p[contains(text(),'Your Order Has Been Cancelled')]") public WebElement cancelationMessage;

@FindBy(id = "returnBtn") public WebElement returnItemBtn;

@FindBy(id = "reasonInput") public WebElement returnReason;

@FindBy(id = "dropOffInput") public WebElement dropOff;

@FindBy(id = "orderSubmitBtn") public WebElement returnBtn;

@FindBy(xpath="//p[contains(text(),'Return was successfull')]") public WebElement returnMessage;

@FindBy(id="reviewBtn")public WebElement reviewBtn;

@FindBy(id="headlineInput") public WebElement headline;

@FindBy(id="descriptionInput") public WebElement description;

@FindBy(id = "reviewSubmitBtn") public WebElement reviewSubmitBtn;

@FindBy(xpath="//div[contains(text(),'Your review was added successfully')]") public WebElement reviewMessage;

@FindBy(className = "order") public WebElement firstOrder;
}
