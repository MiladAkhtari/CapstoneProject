package tek.framework.pages;

import tek.framework.base.BaseSetup;
import tek.framework.pages.RetailAccountPage;

public class POMFactory extends BaseSetup {
	private RetailHomePage homePage;
	private RetailSignInPage signInPage;
	private RetailAccountPage accountPage;
	private RetailOrderPage orderPage;

	public POMFactory() {
		this.homePage = new RetailHomePage();
		this.signInPage = new RetailSignInPage();
		this.accountPage = new RetailAccountPage();
		this.orderPage = new RetailOrderPage();
	}

	public RetailHomePage homepage() {
		return this.homePage;

	}

	public RetailSignInPage SignInPage() {
		return this.signInPage;
	}

	public RetailAccountPage accountPage() {
		return this.accountPage;
	}

	public RetailOrderPage orderPage() {
		return this.orderPage;
	}
}
