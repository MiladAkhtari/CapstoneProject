package tek.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.framework.base.BaseSetup;

public class RetailHomePage extends BaseSetup{
	public RetailHomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id ="signinLink") public WebElement signInBtn;
	
	@FindBy(linkText="TEKSCHOOL") public WebElement tekschoollogo;
	
    @FindBy(id = "searchInput") public WebElement searchBarInput;
    
    @FindBy(id = "searchBtn") public WebElement searchButton;
    
    @FindBy(xpath ="//img[contains(@alt,'Pokemon')]" ) public WebElement pokemonImage;
    
    @FindBy(id="signinLink") public WebElement signInOption;
    
    @FindBy(xpath="//a[text()='Account']") public WebElement accountOption;
    
    @FindBy(id="logoutBtn") public WebElement logoutBtn;
    
    @FindBy(id= "cartBtn") public WebElement cartBtn;
    
    @FindBy(xpath = "//span[text()='All']") public WebElement allSectionBtn;
    
    @FindBy(xpath = "//div[@class='sidebar_content-item']") public List<WebElement> sidebar;
    
    @FindBy(xpath = "//select[@id='search']") public WebElement allCategory;
    
    @FindBy(xpath = "//p[contains(text(),'Kasa Outdoor Smart Plug')]") public WebElement itemToAdd;
    
    @FindBy (xpath ="//select[@class='product__select']") public WebElement qty;
    
    @FindBy(xpath ="//span[(text()='Add to Cart')]") public WebElement addToCart;
    
    @FindBy(xpath = "//span[@id='cartQuantity']") public WebElement cartQty;
    
    @FindBy(id="proceedBtn") public WebElement proceedToCheckoutBtn;
    
    @FindBy(id="addToCartBtn")public WebElement addToCartBtn;
    
    @FindBy(id ="addAddressBtn") public WebElement addAddressLink;
    
    @FindBy(id = "addPaymentBtn") public WebElement addCreditBtn;
    
    @FindBy(id ="placeOrderBtn") public WebElement placeOrderBtn;
    
    @FindBy(xpath = "//div[contains(text(),'Order Placed Successfully')]") public WebElement orderMessage;
    
    @FindBy(xpath = "//p[contains(text(),'Apex Legends - 1,000 Apex Coins')]") public WebElement apexItem;
}
