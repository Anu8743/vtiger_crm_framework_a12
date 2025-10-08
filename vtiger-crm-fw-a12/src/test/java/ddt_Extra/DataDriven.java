package ddt_Extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataDriven {

	public static void main(String[] args) throws IOException {

//		get the java represention object of the physical file 
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		
//		use the load() of properties class to load all the keys value 
		Properties pObj = new Properties();
		pObj.load(fis);
	
//		use the getproperty(key) and pass the key and you will get string value 
		String BROWSER=pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");
		
//		PRINT
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		

	}


}
