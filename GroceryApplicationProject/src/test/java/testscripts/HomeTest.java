package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import retrymechanism.Retry;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase {
	HomePage home;
	@Test(description = " validating user is able to succesfully logout", retryAnalyzer = retrymechanism.Retry.class)
	public void verifyUserIsAbleToSuccessfullyLogout() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home =login.clickOnSignButton();
		home.clickOnAdminIcon();
		login = home.clickOnLogoutIcon();
		String actual = home.getApplicationTitle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constants.USERLOGOUTERROR);

	}
}
 