package io.excel.xlsx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.formula.atp.Switch;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

public class ReadExcel {
	
	private XSSFWorkbook wb ;
	private XSSFSheet ws ;		
	
	//-------------- This method will Load the Excel File --------------
	private void loadExcelFile(String path, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(new File(path));
			wb = new XSSFWorkbook(fis);
			ws = wb.getSheet(sheetName);
			
			
			
		}catch(FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
		
	//---------------- Return Nuber Of Rows --------------
	public int getRowCount(String path, String sheetName) {		
		loadExcelFile(path, sheetName);
		return ws.getLastRowNum();
	}
	
	//---------------- Return Nuber Of Columns --------------
	public int getColumnCount(String path, String sheetName) {		
		loadExcelFile(path, sheetName);
		return ws.getRow(0).getLastCellNum();
	}
	
	//----------------- get the cell values based on Type -----------------
	private Object getCellvaluesBasedOnCellType(XSSFCell cell) {
		Object val = null;
		switch (cell.getCellType()) {
		case STRING:
			val = cell.getStringCellValue();
			break;
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)){
				val = cell.getDateCellValue();
		      }else{
		    	  val = cell.getNumericCellValue();
		    	  
		    	  if((long)Double.parseDouble(val.toString())>0) {
		    		  val = (long)Double.parseDouble(val.toString());
		    	  }
		      }			
			break;
		case BOOLEAN:
			val = cell.getBooleanCellValue();
			break;
		case FORMULA:
			val = cell.getCellFormula();
		    //System.out.println("Formula is " + cell.getCellFormula());
	        switch(cell.getCachedFormulaResultType()) {
	            case NUMERIC:
	                val = cell.getNumericCellValue();
	                break;
	            case STRING:
	                val = cell.getRichStringCellValue();
	                break;
	        }
			break;
		case BLANK:
			val = "";
			break;
			
		default:
			break;
		}
		return val;
	}
	
	//--------------------- print The Excel Rowise ------------------
	public void printExcelRowWise(String path, String sheetName) {
		
		int rowNum = getRowCount(path,sheetName);
		int columnNum = getColumnCount(path,sheetName);
		
		for(int row =0; row <= rowNum; row++) {
			String rowValue = "";
			for(int column =0; column < columnNum ; column++) {
				 rowValue=  rowValue + getCellvaluesBasedOnCellType(ws.getRow(row).getCell(column)).toString() + " | ";
			}
			
			System.out.println(rowValue + "\n");
			
			try {
				wb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	@Test
	void test_1() {
		String path = System.getProperty("user.dir").concat("\\src\\main\\java\\io\\excel\\xlsx\\Company.xlsx");
		//String path = "D:\\Work\\Projects\\Java\\SeleniumJava\\selenium_tutorial\\src\\main\\java\\io\\excel\\xlsx\\Company.xlsx";
		String sheet = "Employees";
		
		System.out.println("Number Of Rows : " + (getRowCount(path, sheet)+1));
		System.out.println("Number Of Columns : " + getColumnCount(path, sheet) + "\n");
		printExcelRowWise(path, sheet);
	}
}
