package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends TestNGBase {

	@Test(priority = 1, description = "validating user is able to add news to news list")
	public void verifyUserIsAbleTOAddNewNews() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignButton();
		HomePage home = new HomePage(driver);
		home.clickOnManageNewsMoreInfoIcon();
		String newsheadline = ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		ManageNewsPage news = new ManageNewsPage(driver);
		news.clickOnAddNewsButton();
		news.enterNews(newsheadline);
		news.clickOnSaveNewsButton();

	}

	@Test(priority = 2, description = "validating user is able to search for a news from the news list")
	public void verifyUserIsAbleTOSearchNews() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignButton();
		HomePage home = new HomePage(driver);
		home.clickOnManageNewsMoreInfoIcon();
		String newsheading = ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		ManageNewsPage news = new ManageNewsPage(driver);
		news.clickOnSearchButton();
		news.searchforNews(newsheading);
		news.performSearch();
	}

	@Test(priority = 3, description = "validating user is able to reset news list")
	public void verifyUserIsAbleToResetNews() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignButton();
		HomePage home = new HomePage(driver);
		home.clickOnManageNewsMoreInfoIcon();
		ManageNewsPage news = new ManageNewsPage(driver);
		news.clickOnResetButton();

	}
}
