package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataProvider {
	
	static XSSFWorkbook wb;
	
	//public ExcelDataProvider() throws IOException{
		
	//	File src=new File("./TestData/TestData.xlsx");
	//	FileInputStream fis= new FileInputStream(src);
	//	wb= new XSSFWorkbook(fis);
	//}

	public static String getStringData(String SheetName,int row,int col) throws IOException{
		File src=new File("./TestData/TestData.xlsx");
			FileInputStream fis= new FileInputStream(src);
			wb= new XSSFWorkbook(fis);
		
		return wb.getSheet(SheetName).getRow(row).getCell(col).getStringCellValue();
		
	}
	
	public static double getNumericData(String SheetName,int row,int col){
		return wb.getSheet("SheetName").getRow(row).getCell(col).getNumericCellValue();
	}
}
