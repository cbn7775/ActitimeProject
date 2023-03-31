package Com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Com.Actitime.Pom.LoginPage;

public class Base_Class {
	public static WebDriver D;   //creating global variable launch the browser
	File_Library f= new File_Library();  //use to call  non static methods from File_Library class
	
@BeforeSuite
public void databseconnection() {
	Reporter.log("Database is connected successfully",true);
}

@AfterSuite
public void databasedisconnection() {
	Reporter.log("Database is Disconnected successfully",true);
}

@BeforeClass
public void launchBrowser() throws IOException {
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
	 D = new ChromeDriver(option);
	D.manage().window().maximize();
	D.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	String URL = f.readDataFromProperty("url"); //calling non static method
	D.get(URL);
	Reporter.log("browser launched",true);
}

@AfterClass
public void closeBrowser() {
	D.close();
	Reporter.log("browser closed",true);
}
@BeforeMethod
public void login() throws IOException {
	String UN = f.readDataFromProperty("username");    //calling non static method
	String PW = f.readDataFromProperty("password");    //calling non static method
	LoginPage lp = new LoginPage(D);
	lp.getUntbx().sendKeys(UN);
	lp.getPwtbx().sendKeys(PW);
	lp.getLgbtn().click();
	Reporter.log("logged in  successfully",true);
}
@AfterMethod
public void logout() {
	D.findElement(By.linkText("Logout")).click();
	Reporter.log("logged out successfully",true);
}
}
