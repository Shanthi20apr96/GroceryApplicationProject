package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle = 'dropdown']") WebElement adminicon;
	@FindBy(xpath = "//a[@href ='https://groceryapp.uniqassosiates.com/admin/logout']")	WebElement logouticon;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class = 'small-box-footer']")	WebElement infoicon;
	@FindBy(xpath = "//a[@href ='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']") WebElement newsinfoicon;
	@FindBy(xpath = "//b[text() ='7rmart supermarket']") WebElement apptitle;

	public HomePage clickOnAdminIcon() {
		adminicon.click();
		return this;
	}

	public LoginPage clickOnLogoutIcon() {
		logouticon.click();
		return new LoginPage(driver);
	}

	public AdminUsersPage clickOnAdminUsersMoreInfoIcon() {
		infoicon.click();
		return new AdminUsersPage(driver);
	}

	public ManageNewsPage clickOnManageNewsMoreInfoIcon() {
		newsinfoicon.click();
		return new ManageNewsPage(driver);
	}
	public String getApplicationTitle() {
		return apptitle.getText();
}
}
