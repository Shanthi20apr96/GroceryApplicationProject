package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {
	public WebDriver driver;
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
	
	//Methods for adding new users
	public void clickOnNewButton() {
		newbutton.click();
	}
	
	public void addUserName(String newuser) {
		addnewusername.sendKeys(newuser);
	}
	
	public void addPassword(String newuserpassword) {
		addpassword.sendKeys(newuserpassword);
	}
	
	public void selectDropdown() {
		Select select = new Select(dropdown);
		select.selectByValue("admin");
	}
	
	
	public void clickSaveButton() {
		savebutton.click();
	}
	
	// methods for Searching a user
	
	public void clickOnSearchButton() {
		searchbutton.click();
	}
	public void searchForUserName(String searchusername) {
		searchforusername.sendKeys(searchusername);
	}
	
	public void searchForUserType() {
		Select select = new Select(searchforusertype);
		select.selectByValue("admin");
	}
	public void performSearch() {
		performsearch.click();
	}
	
	//methods for resetting users list
	
	public void clickOnResetButton() {
		resetbutton.click();
	}
	
	
}
