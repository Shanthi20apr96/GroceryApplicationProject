package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "username")
	WebElement usernamefield;
	@FindBy(name = "password")
	WebElement passwordfield;
	@FindBy(xpath = "//button[text() = 'Sign In']")
	WebElement signinbtn;
	@FindBy(xpath = "//p[text() ='Dashboard']")
	WebElement dashboardtile;
	@FindBy(xpath = "//b[text() ='7rmart supermarket']")
	WebElement apptitle;

	public LoginPage enterUsernameOnUsernameField(String username) {
		usernamefield.sendKeys(username);
		return this;

	}

	public LoginPage enterPasswordOnPasswordField(String password) {
		passwordfield.sendKeys(password);
		return this;
	}

	public HomePage clickOnSignButton() {
		signinbtn.click();
		return new HomePage(driver);
	}

	public boolean isDashboardDisplayed() {
		return dashboardtile.isDisplayed();
	}

	public String getApplicationTitle() {
		return apptitle.getText();

	}

	public boolean isSignInbuttonSelected() {
		return signinbtn.isSelected();
	}

}
