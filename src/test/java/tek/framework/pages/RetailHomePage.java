package tek.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.framework.base.BaseSetup;

public class RetailHomePage extends BaseSetup{
	public RetailHomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id ="signinLink")
	public WebElement signInBtn;
	
	
	@FindBy(linkText="TEKSCHOOL") public WebElement tekschoollogo;
	
    @FindBy(id = "searchInput") public WebElement searchBarInput;
    
    @FindBy(id = "searchBtn") public WebElement searchButton;
    
    @FindBy(xpath ="//img[contains(@alt,'Pokemon')]" ) public WebElement pokemonImage;
    
    @FindBy(id="signinLink") public WebElement signInOption;
    
    @FindBy(xpath="//a[text()='Account']") public WebElement accountOption;
    
    @FindBy(id="logoutBtn") public WebElement logoutBtn;
    
    @FindBy(id= "cartBtn") public WebElement cartBtn;
}
