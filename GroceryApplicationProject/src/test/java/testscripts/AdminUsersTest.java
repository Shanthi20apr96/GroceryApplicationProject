package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtiity;

public class AdminUsersTest extends TestNGBase {
	
	@Test
	public void verifyUserIsAbleToAddNewUser() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignButton();
		HomePage home = new HomePage(driver);
		home.clickOnAdminUsersMoreInfoIcon();
		FakerUtiity faker = new FakerUtiity();
		String newuser = faker.createRandomUserName();
		String newuserpassword = faker.createRandomPassword();
		AdminUsersPage admin = new AdminUsersPage(driver);
		admin.clickOnNewButton();
		admin.addUserName(newuser);
		admin.addPassword(newuserpassword);
		admin.selectDropdown();
		admin.clickSaveButton();
		
	}
	
	@Test
	public void verifyUserIsAbleToSearchAUser() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignButton();
		HomePage home = new HomePage(driver);
		home.clickOnAdminUsersMoreInfoIcon();
		String searchusername = ExcelUtility.readStringData(0, 0, "AdminUsersPage");
		AdminUsersPage admin = new AdminUsersPage(driver);
		admin.clickOnSearchButton();
		admin.searchForUserName(searchusername);
		admin.searchForUserType();
		admin.performSearch();		
		
	}
	
	@Test
	public void verifyUserIsAbleToResetUsersList() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignButton();
		HomePage home = new HomePage(driver);
		home.clickOnAdminUsersMoreInfoIcon();
		AdminUsersPage admin = new AdminUsersPage(driver);
		admin.clickOnResetButton();
	}
}
