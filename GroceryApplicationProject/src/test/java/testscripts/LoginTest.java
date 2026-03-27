package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import retrymechanism.Retry;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {
	HomePage home;
	@Test(priority = 1, description = "validating user login with valid credentials", groups = {"smoke"}, retryAnalyzer = Retry.class)

	public void verifyUserLoginWithValidCredentials() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home = login.clickOnSignButton();
		boolean dashboardDisplay = login.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplay, Constants.VALIDCREDENTIALERROR);
	}

	@Test(priority = 2, description = "validating user login with valid username and invalid password", groups = {"smoke"})
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home =login.clickOnSignButton();
		String actual = login.getApplicationTitle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constants.INVALIDPASSWORDERROR);
	}

	@Test(priority = 3, description = "validating user login with invalid username and valid password ")
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home =login.clickOnSignButton();
		String actual = login.getApplicationTitle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constants.INVALIDUSERNAMEERROR);
	}

	@Test(priority = 5, description = "validating user login with invalid username and invalid password", dataProvider = "loginProvider")
	public void verifyUserLoginWithInvalidCredentials(String username, String password) throws IOException {
		//String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		//String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home = login.clickOnSignButton();
		Boolean signInbtnSelected = login.isSignInbuttonSelected();
		Assert.assertFalse(signInbtnSelected, Constants.INVALIDCREDENTIALERROR);
	}
	
	 @DataProvider(name = "loginProvider") 
	 	public Object[][] getDataFromDataProvider() throws IOException { 
	  
	 		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" }, 
	 				// new Object[] {ExcelUtility.getStringData(3, 
	 				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")} 
	 		}; 
	 	}

}
