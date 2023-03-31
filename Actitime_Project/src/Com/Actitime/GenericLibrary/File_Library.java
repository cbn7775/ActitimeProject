package Com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * this class is a generic class which is have non-static methods to perform data driver testing  from property file.
 * @author Chaitanya
 *
 */
public class File_Library {
	/**
	 * this method is a non- static method which is used to read the data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	//class for datadriven 
public String readDataFromProperty(String key) throws IOException   {
	FileInputStream fis= new FileInputStream("./Testdata/commondata.property.txt");  //read data from property file
	Properties p = new Properties();
	p.load(fis);                                                 // load the file 
	 String value = p.getProperty(key);
	return value;
}
/**
 * this method is a non static method used to read the data from excel sheet
 * @param sheetname
 * @param row
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String readDataFromExcel(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis1 = new FileInputStream("Testdata/Actitime Test Data.xlsx"); //read data from excel file
		Workbook wb = WorkbookFactory.create(fis1);
	String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}



}
