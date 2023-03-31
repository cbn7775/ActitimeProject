package Com.Actitime.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Com.Actitime.GenericLibrary.Base_Class;
import Com.Actitime.GenericLibrary.File_Library;
import Com.Actitime.Pom.HomePage;
import Com.Actitime.Pom.TaskPage;

public class Task_test extends Base_Class{
@Test
public void createCustomer() throws EncryptedDocumentException, IOException {
	HomePage hp = new HomePage(D);
	hp.getTasklnk().click();
	
	TaskPage tp= new TaskPage(D);
	tp.getAddnewbtn().click();
	tp.getNewcust().click();
	
	File_Library f= new File_Library();
	String name = f.readDataFromExcel("Sheet1", 4, 1);
	tp.getCustname().sendKeys(name);
	String desp = f.readDataFromExcel("Sheet1", 4, 2);
	tp.getCustdesp().sendKeys(desp);
	tp.getCreatecust().click();
	
	
	
	
	
}
}
