package object_repository;

import java.io.IOException;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utilities.FileUtility;

public class LoginPage {
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(name="user_name")
		private WebElement  un;
		
		@FindBy(name="user_password")
		private WebElement pwd;
		
		@FindBy(id = "submitButton")
		private WebElement LoginButton;
		

		public WebElement getPwd() {
			return pwd;
		}


		public WebElement getLoginButton() {
			return LoginButton;
		}


		public WebElement getUn() {
			return un;
		}
//		Business utility 
		public void login() throws IOException {
			FileUtility fUtil = new FileUtility();
			String USERNAME = fUtil.getDataFromPropertiesFile("un");
			String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");
			
			un.sendKeys(USERNAME);
			pwd.sendKeys(PASSWORD);
			LoginButton.click();
		}

		
	}

