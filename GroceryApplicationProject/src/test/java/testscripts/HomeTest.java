package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase{

	@Test
	public void verifyUserIsAbleToSuccessfullyLogout() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignButton();
		HomePage home = new HomePage(driver);
		home.clickOnAdminIcon();
		home.clickOnLogoutIcon();
		
	
	}
}
