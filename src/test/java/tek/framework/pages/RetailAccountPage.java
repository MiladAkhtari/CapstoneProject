package tek.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.framework.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {
	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);	
	}
	
	@FindBy(xpath = "//img[@alt='profile pic']")
	public  WebElement accountProfilePicture;
	
	@FindBy(id= "logoutBtn")
	public WebElement logoutBtn;
	
	@FindBy(id = "nameInput")
	public WebElement nameField;
	
	@FindBy(id = "personalPhoneInput")
	public WebElement phoneNumberField;
	
	@FindBy(id = "personalUpdateBtn")
	public WebElement updateBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Personal Information Updated Successfully')]")
	public WebElement updateMessage;
	
	@FindBy(xpath="//h1[@class='account__information-username']")
	public WebElement name;
	
	@FindBy(id= "previousPasswordInput")
	public WebElement previousPasswordField;
	
	@FindBy(id = "newPasswordInput")
	public WebElement newPasswordField;
	
	@FindBy(id = "confirmPasswordInput")
	public WebElement confirmPasswordField;
	
	@FindBy(id ="credentialsSubmitBtn")
	public WebElement changePasswordBtn;
	
	
	@FindBy(xpath = "//div[contains(text(),'Password Updated Successfully')]")
	public WebElement updatedPasswordMessage;
	
	@FindBy(xpath= "//p[contains(text(),'Add a payment method')]")
	public WebElement addPaymentLink;
	
	@FindBy(id = "cardNumberInput")
	public WebElement cardNumberField;
	
	@FindBy(id = "nameOnCardInput")
	public WebElement nameOnCardField;
	
	@FindBy(id = "expirationMonthInput")
	public WebElement expirationMonthField;
	
	@FindBy(id = "expirationYearInput")
	public WebElement expirationYearField;
	
	@FindBy(id = "securityCodeInput")
	public WebElement securityCodeField;
	
	@FindBy(id = "paymentSubmitBtn")
	public WebElement addCardBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Payment Method added sucessfully')]")
	public WebElement paymentMethodMessage;
	
	
}
