package io.excel.xlsx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

public class ReadExcel {
	
	private XSSFWorkbook wb ;
	private XSSFSheet ws ;		
	
	//-------------- This method will Load the Excel File --------------
	private void loadExcelFile(String Path, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir").concat("\\src\\main\\java\\io\\excel\\xlsx\\Company.xlsx")));
			wb = new XSSFWorkbook(fis);
			ws = wb.getSheet("sheetName");
			
			
			
		}catch(FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	
	//---------------- Return Nuber Of Rows --------------
	public int getRowCount(String Path, String sheetName) {		
		loadExcelFile(Path, sheetName);
		return ws.getLastRowNum();
	}
	
	//---------------- Return Nuber Of Columns --------------
	public int getRowCount(String Path, String sheetName) {		
		loadExcelFile(Path, sheetName);
		return ws.getLastRowNum();
	}
	
	public static void printExcelRowWise() {
		
		
		
	}
	
}
