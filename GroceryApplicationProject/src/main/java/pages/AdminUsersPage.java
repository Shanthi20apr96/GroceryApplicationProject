package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {
	public WebDriver driver;
	WaitUtility wait = new WaitUtility();
	PageUtility page = new PageUtility();
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locating web elements for adding new users
	@FindBy(xpath ="//a[@class= 'btn btn-rounded btn-danger']") WebElement newbutton;
	@FindBy(id = "username") WebElement addnewusername;
	@FindBy(id ="password") WebElement addpassword;
	@FindBy(id ="user_type") WebElement dropdown;
	@FindBy(xpath = "//button[@class ='btn btn-block-sm btn-danger' and @name = 'Create']") WebElement savebutton;
	
	
	// Locating web elements for Searching a user
	@FindBy(xpath ="//a[@class= 'btn btn-rounded btn-primary']") WebElement searchbutton;
	@FindBy(xpath ="//input[@class='form-control' and @id='un']") WebElement searchforusername;
	@FindBy(xpath = "//select[@class='form-control' and @id='ut']")	WebElement searchforusertype;
	@FindBy(xpath = "//button[@type='submit' and @name='Search']") WebElement performsearch;
	
	//Locating web elements for Resetting users list
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-warning']") WebElement resetbutton;
	
	//@FindBy(xpath ="//div [@class='alert alert-success alert-dismissible']") WebElement usercreatedmsg;
	@FindBy(xpath = "//button[@class=\"close\"]") WebElement closebtn;
	@FindBy(xpath ="//h1[text() ='Admin Users']") WebElement titledisplayed;
	
	//Methods for adding new users
	public AdminUsersPage clickOnNewButton() {
		newbutton.click();
		return this;
	}
	
	public AdminUsersPage addUserName(String newuser) {
		addnewusername.sendKeys(newuser);
		return this;
	}
	
	public AdminUsersPage addPassword(String newuserpassword) {
		addpassword.sendKeys(newuserpassword);
		return this;
	}
	
	public AdminUsersPage selectDropdown(String usertype) {
		//Select select = new Select(dropdown);
		//select.selectByValue("admin");
		page.selectDropdownWithValue(dropdown, usertype);
		return this;
	}
	
	
	public AdminUsersPage clickSaveButton() {
		wait.waitUntilElementToBeClickable(driver, savebutton);
		savebutton.click();
		return this;
	}
	
	// methods for Searching a user
	
	public AdminUsersPage clickOnSearchButton() {
		searchbutton.click();
		return this;
	}
	public AdminUsersPage searchForUserName(String searchusername) {
		searchforusername.sendKeys(searchusername);
		return this;
	}
	
	public AdminUsersPage searchForUserType() {
		//Select select = new Select(searchforusertype);
		//select.selectByValue("admin");
		page.selectDropdownWithIndex(searchforusertype, 0);
		return this;
	}
	public AdminUsersPage performSearch() {
		performsearch.click();
		return this;
	}
	
	//methods for resetting users list
	
	public AdminUsersPage clickOnResetButton() {
		resetbutton.click();
		return this;
	}
	 //public String userCreatedMsg() {
		// return usercreatedmsg.getText();
		 
	 public boolean verifyClosebuttonIsDisplayed() {
		 return closebtn.isDisplayed();
	 }
	 
	 public String verifyAdminUserTitle() {
		 return titledisplayed.getText();
	 }
	
	
}
