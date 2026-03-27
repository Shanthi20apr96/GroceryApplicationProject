package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constants.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends TestNGBase {
	HomePage home;
	AdminUsersPage admin;
	ManageNewsPage news;
	@Test(description = "validating user is able to add news to news list")
	public void verifyUserIsAbleTOAddNewNews() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		//HomePage home = new HomePage(driver);
		home =login.clickOnSignButton();
		news =home.clickOnManageNewsMoreInfoIcon();
		String newsheadline = ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		news.clickOnAddNewsButton().enterNews(newsheadline).clickOnSaveNewsButton();
		boolean isClosebtndisplayed = news.verifyClosebuttonIsDisplayed();
		Assert.assertTrue(isClosebtndisplayed, Constants.ADDNEWNEWSSERROR);

	}

	@Test(description = "validating user is able to search for a news from the news list")
	public void verifyUserIsAbleTOSearchNews() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home =login.clickOnSignButton();
		news =home.clickOnManageNewsMoreInfoIcon();
		String newsheading = ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		//ManageNewsPage news = new ManageNewsPage(driver);
		news.clickOnSearchButton().searchforNews(newsheading).performSearch();
		String actual = news.verifyManageNewsTitle();
		String expected = "Manage News";
		Assert.assertEquals(actual, expected,Constants.SEARCHNEWSLISTERROR);
	}

	@Test(description = "validating user is able to reset news list")
	public void verifyUserIsAbleToResetNews() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		//HomePage home = new HomePage(driver);
		home = login.clickOnSignButton();		
		news = home.clickOnManageNewsMoreInfoIcon();
		//ManageNewsPage news = new ManageNewsPage(driver);
		news.clickOnResetButton();
		String actual = news.verifyManageNewsTitle();
		String expected = "Manage News";
		Assert.assertEquals(actual, expected,Constants.REFRESHNEWSLISTERROR);

	}
}
