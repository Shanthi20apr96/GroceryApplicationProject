package testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constants.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtiity;

public class AdminUsersTest extends TestNGBase {
	HomePage home;
	AdminUsersPage admin;
	@Test(description= "validating user is able to add new user to the users list")
	
	public void verifyUserIsAbleToAddNewUser() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home =login.clickOnSignButton();
		//AdminUsersPage admin = new AdminUsersPage(driver);
		admin = home.clickOnAdminUsersMoreInfoIcon();
		FakerUtiity faker = new FakerUtiity();
		String newuser = faker.createRandomUserName();
		String newuserpassword = faker.createRandomPassword();
		String usertype = ExcelUtility.readStringData(0, 2, "AdminUsersPage");
		admin.clickOnNewButton().addUserName(newuser).addPassword(newuserpassword).selectDropdown(usertype).clickSaveButton();
		boolean isClosebtndisplayed = admin.verifyClosebuttonIsDisplayed();
		Assert.assertTrue(isClosebtndisplayed, Constants.ADDNEWUSERSERROR);
		
	}
	
	@Test (description = "validating user is able to search a user from the users list")
	public void verifyUserIsAbleToSearchAUser() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home =login.clickOnSignButton();
		admin =home.clickOnAdminUsersMoreInfoIcon();
		String searchusername = ExcelUtility.readStringData(0, 0, "AdminUsersPage");
		admin.clickOnSearchButton().searchForUserName(searchusername).searchForUserType().performSearch();		
		String actual = admin.verifyAdminUserTitle();
		String expected = "Admin Users";
		assertEquals(actual, expected, Constants.SEARCHUSERLISTERROR);
	}
	
	@Test(description = "validating user is able to reset users list")
	public void verifyUserIsAbleToResetUsersList() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home =login.clickOnSignButton();
		admin =home.clickOnAdminUsersMoreInfoIcon();
		admin.clickOnResetButton();
		String actual = admin.verifyAdminUserTitle();
		String expected = "Admin Users";
		assertEquals(actual, expected, Constants.REFRESHUSERLISTERROR);

	}
}
