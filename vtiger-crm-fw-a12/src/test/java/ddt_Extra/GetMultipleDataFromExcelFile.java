package ddt_Extra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetMultipleDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis =new FileInputStream("./src/test/resources/testScriptData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet("A12");
		
		
	    for (int i = 1; i < sh.getLastRowNum(); i++) {
	    	Row row = sh.getRow(i);
	    	
//			Cell cell=  row.getCell(0);
//			String value = cell.getStringCellValue();
//			System.out.println(value);
	    	
	    	
//	    	Cell cell=  row.getCell(0); replace this 
//	    	method chaining
			String value = row.getCell(0).getStringCellValue();
			System.out.println(value);
			
//			Cell cell1=  row.getCell(1);
			String value1 = row.getCell(1).getStringCellValue();
			System.out.println(value1);
		}
	}

}
