package Contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base_utility.BaseClasss;
import config_anno_extra.BaseClass;
import generic_Utilities.FileUtility;
import gu_extra.WebDriverUtility;
import object_repository.LoginPage;

public class CreteContactTestAfterBaseClass extends BaseClasss{
	@Test
	
	public void createContTest()throws InterruptedException, EncryptedDocumentException, IOException {
		FileUtility fUtil = new FileUtility();
		
//		Get the data from excelflie

		FileInputStream fisExcel = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fisExcel);
		Sheet sh = wb.getSheet("LastName");
		Row row = sh.getRow(13);
		Cell cell = row.getCell(0);
		String LastName = cell.getStringCellValue() + (int) (Math.random() * 1000);
		wb.close();

//		Open Browser 
//		Login
		
//		Create Organization
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

//		Filling data to the form
		WebElement lastnameField = driver.findElement(By.name("lastname"));
		lastnameField.sendKeys(LastName);

//		save button
		driver.findElement(By.xpath("//input[contains(@value,'  Save  ')]")).click();

//		Verification
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		Assert.assertTrue(actLastName.equals(lastName));

//		if (actLastName.equals(LastName)) {
//			System.out.println("Created Contact " + LastName + "successfully!!!!");
//		} else {
//			System.out.println("Failed....");
//		}

		driver.findElement(By.linkText("Sign Out")).click();

	}
}
