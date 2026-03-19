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

	@FindBy(xpath = "//a[@data-toggle = 'dropdown']")
	WebElement adminicon;
	@FindBy(xpath = "//a[@href ='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement logouticon;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class = 'small-box-footer']")
	WebElement infoicon;
	@FindBy(xpath = "//a[@href ='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")
	WebElement newsinfoicon;

	public void clickOnAdminIcon() {
		adminicon.click();
	}

	public void clickOnLogoutIcon() {
		logouticon.click();
	}

	public void clickOnAdminUsersMoreInfoIcon() {
		infoicon.click();
	}

	public void clickOnManageNewsMoreInfoIcon() {
		newsinfoicon.click();
	}
}
