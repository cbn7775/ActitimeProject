package Com.Actitime.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
//declaration
	
	@FindBy(xpath = "//div[.='Tasks']")
	private WebElement tasklnk;
	
	@FindBy(xpath = "//div[.='Reports']")
	private WebElement reportslnk;
	
	@FindBy(xpath = "//div[.='Users']")
	private WebElement userslnk;
	
	@FindBy(id = "logoutLink")
	private WebElement logoutlnk;
	
	//initialization
	public HomePage(WebDriver D) {          //constructor
		PageFactory.initElements(D, this);
	}
	
	//utilization

	public WebElement getTasklnk() {
		return tasklnk;
	}

	public WebElement getReportslnk() {
		return reportslnk;
	}

	public WebElement getUserslnk() {
		return userslnk;
	}

	public WebElement getLogoutlnk() {
		return logoutlnk;
	}
	
	
	
	
	
}
