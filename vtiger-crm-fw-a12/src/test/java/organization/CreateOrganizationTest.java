package organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import generic_Utilities.FileUtility;
import gu_extra.WebDriverUtility;
import object_repository.HomePage;
import object_repository.OrgPage;
import object_repository.VerifyOrgPage;
import pom_extra.LoginPage;

public class CreateOrganizationTest {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {

////		get the java represention object of the physical file 
//		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
//		
////		use the load() of properties class to load all the keys value 
//		Properties pObj = new Properties();
//		pObj.load(fis);
//	
////		use the getproperty(key) and pass the key and you will get string value 
//		String BROWSER = pObj.getProperty("bro");
//		String URL = pObj.getProperty("url");
//		String USERNAME = pObj.getProperty("un");
//		String PASSWORD = pObj.getProperty("pwd");
//	
////		PRINT
//		System.out.println(BROWSER);
//		System.out.println(URL);
//		System.out.println(USERNAME);
//		System.out.println(PASSWORD);
//		
////		How to create execlflie
//		
//		FileInputStream fisExcel = new FileInputStream("./src/test/resources/testScriptData.xlsx");
//
//		Workbook wb = WorkbookFactory.create(fisExcel);
//
//		Sheet sh = wb.getSheet("org");
//
//		Row row = sh.getRow(8);
//
//		Cell cell = row.getCell(0);
//
//		String value = cell.getStringCellValue()+ (int)(Math.random()*1000);
//
//		System.out.println(value);		
		FileUtility fUtil = new FileUtility();

//		Get the data from properties file
		String BROWSER = fUtil.getDataFromPropertiesFile("bro");
		String URL = fUtil.getDataFromPropertiesFile("url");

//		Get the data from excel file
		String orgName = fUtil.getStringDataFromExcelFile("org", 3, 0);

//		Open Browser 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		Login
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
//		WebElement username = lp.getUn();
//		username.sendKeys(USERNAME);
//		WebElement password = lp.getPwd();
//		password.sendKeys(PASSWORD);
//
//		lp.getLoginButton().click();

		lp.getLogin();
		Thread.sleep(3000);

//		Create Organization
		HomePage hp = new HomePage(driver);
		hp.getOrgName();

		OrgPage op = new OrgPage(driver);
		op.getCreateOrg();

//		Filling data to the form
		WebElement orgField = op.getOrgField();
//		String orgName = "automationWithAnu";
		orgField.sendKeys(orgName);

		Thread.sleep(3000);
//		Save 
		Thread.sleep(3000);
//		Save 
		op.getSaveBtn().click();

//		Verification
		VerifyOrgPage vop = new VerifyOrgPage(driver);
		String actOrgName = vop.getActOrgName().getText();

		if (actOrgName.equals(orgName)) {
			System.out.println("Created Organization successfully!!!!");
		} else {
			System.out.println("Failed....");
		}

		WebElement profilePic = hp.getProfilePic();
		WebDriverUtility wdUtil = new WebDriverUtility(driver);

		Actions act = new Actions(driver);
		act.moveToElement(profilePic).build().perform();
		wdUtil.hover(profilePic);

//		signout

		Thread.sleep(2000);
		hp.getSignout().click();
		;
		Thread.sleep(3000);
		driver.quit();

	}
}
