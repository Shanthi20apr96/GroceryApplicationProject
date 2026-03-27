package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Locating elements to add news
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement addbtn;
	@FindBy(id ="news") WebElement enternewsdata;
	@FindBy(xpath ="//button[text()= 'Save']") WebElement savebtn;
	
	
	//Locating elements to search news
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']") WebElement searchbtn;
	@FindBy(xpath = "//input[@class='form-control' and @name ='un']") WebElement newstitle;
	@FindBy(xpath ="//button[@class='btn btn-danger btn-fix' and @name ='Search']") WebElement performsearch;
	@FindBy(xpath ="//h1[text() ='Manage News']") WebElement titledisplayed;
	
	
	//Locating elements to reset news
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']") WebElement resetbtn;

	
	@FindBy(xpath = "//button[@class='close']") WebElement closebtn;
	//methods to add news
	
	public ManageNewsPage clickOnAddNewsButton() {
		addbtn.click();
		return this;
	}
	public ManageNewsPage enterNews(String newsheadline) {
		enternewsdata.sendKeys(newsheadline);
		return this;
	}
	public ManageNewsPage clickOnSaveNewsButton() {
		savebtn.click();
		return this;
	}
	
	//methods to search news
	
	public ManageNewsPage clickOnSearchButton() {
		searchbtn.click();
		return this;
	}
	
	public ManageNewsPage searchforNews(String newsheading) {
		newstitle.sendKeys(newsheading);
		return this;
		
	}
	
	public ManageNewsPage performSearch() {
		performsearch.click();
		return this;
	}
	
	//method to reset news
	public ManageNewsPage clickOnResetButton() {
		resetbtn.click();
		return this;
	}
	
	 public boolean verifyClosebuttonIsDisplayed() {
		 return closebtn.isDisplayed();
	 }
	 public String verifyManageNewsTitle() {
		 return titledisplayed.getText();
}
}
