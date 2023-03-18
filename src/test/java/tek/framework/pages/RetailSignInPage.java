package tek.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.framework.base.BaseSetup;

public class RetailSignInPage extends BaseSetup {
	public RetailSignInPage() {
        PageFactory.initElements(getDriver(), this);
    }
    @FindBy(xpath = "//h1[text()='TEKSCHOOL']") public WebElement title;
    
    @FindBy(xpath = "//h1[text()='Sign in']") public WebElement subtitle;
    
    @FindBy(id = "email") public WebElement emailInput;
    
    @FindBy(id = "password") public WebElement passwordInput;
    
    @FindBy(id = "loginBtn") public WebElement loginBtn;
    
    @FindBy (id = "newAccountBtn") public WebElement createAccountBtn;
    
    @FindBy (id = "newCompanyAccount") public WebElement companyAccount;
    
    @FindBy(id = "nameInput") public WebElement nameField;
    
    @FindBy(id = "emailInput") public WebElement emailField;
    
    @FindBy(id = "passwordInput") public  WebElement passwordField;
    
    @FindBy(id= "confirmPasswordInput") public WebElement confirmPasswordField;
    
    @FindBy(id = "signupBtn") public WebElement signUpBtn;

}
