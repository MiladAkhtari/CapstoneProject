package tek.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.framework.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {
	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);	
	}
	
	@FindBy(xpath = "//img[@alt='profile pic']") public  WebElement accountProfilePicture;
	
	@FindBy(id= "logoutBtn") public WebElement logoutBtn;
	
	@FindBy(id = "nameInput") public WebElement nameField;
	
	@FindBy(id = "personalPhoneInput") public WebElement phoneNumberField;
	
	@FindBy(id = "personalUpdateBtn") public WebElement updateBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Personal Information Updated Successfully')]") public WebElement updateMessage;
	
	@FindBy(id= "previousPasswordInput") public WebElement previousPasswordField;
	
	@FindBy(id = "newPasswordInput") public WebElement newPasswordField;
	
	@FindBy(id = "confirmPasswordInput") public WebElement confirmPasswordField;
	
	@FindBy(id ="credentialsSubmitBtn") public WebElement changePasswordBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Password Updated Successfully')]") public WebElement updatedPasswordMessage;
	
	@FindBy(xpath= "//p[contains(text(),'Add a payment method')]") public WebElement addPaymentLink;
	
	@FindBy(id = "cardNumberInput") public WebElement cardNumberField;
	
	@FindBy(id = "nameOnCardInput") public WebElement nameOnCardField;
	
	@FindBy(id = "expirationMonthInput") public WebElement expirationMonthField;
	
	@FindBy(id = "expirationYearInput") public WebElement expirationYearField;
	
	@FindBy(id = "securityCodeInput") public WebElement securityCodeField;
	
	@FindBy(id = "paymentSubmitBtn") public WebElement addCardBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Payment Method added sucessfully')]") public WebElement paymentMethodMessage;
	
	@FindBy(xpath = "//p[contains(text(),'Visa Card')] | //p[contains(text(),'Master Card')]") public WebElement card;
	
	@FindBy(xpath = "//button[contains(text(),'Edit')]") public WebElement editBtn;
	
	@FindBy(xpath = "//button[@id='paymentSubmitBtn']") public WebElement UpdateCardBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Payment Method updated Successfully')]") public WebElement updateCardMessage;
	
	@FindBy (xpath = "//button[contains(text(),'remove')]") public WebElement removeCardBtn;
	
	//Add Address
	@FindBy(xpath = "//p[contains(text(),'Add Address')]") public WebElement addAddress;
	
	@FindBy(xpath ="//select[@id='countryDropdown']") public WebElement countryDropdown;
	
	@FindBy(id = "fullNameInput") public WebElement fullName;
	
	@FindBy(id = "phoneNumberInput") public WebElement phoneNumber;
	
	@FindBy(id = "streetInput") public WebElement street;
	
	@FindBy(id = "apartmentInput") public WebElement apt;
	
	@FindBy(id = "cityInput") public WebElement city;
	
	@FindBy(xpath = "//select[@name='state']") public WebElement state;
	
	@FindBy(id = "zipCodeInput") public WebElement zip;
	
	@FindBy(id = "addressBtn") public WebElement addressBtn;
	
	@FindBy (xpath ="//div[contains(text(),'Address Added Successfully')]") public WebElement addressMessage;
	//edit address
	@FindBy (xpath = "//button[contains(text(),'Edit')]") public WebElement editAddressBtn;
	
	@FindBy(id = "addressBtn") public WebElement updateAddressBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Address Updated Successfully')]") public WebElement updatedAddressMessage;
	//remove address option
	@FindBy(xpath = "//button[contains(text(),'Remove')]") public WebElement removeAddressBtn;
}
