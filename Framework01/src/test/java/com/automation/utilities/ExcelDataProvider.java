package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;

	public ExcelDataProvider() {

		File src = new File("./testdata/testdata.xlsx");

		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unale to read excel file " +e.getMessage());
			
		}
	}
	
	public String getStringData(String SheetName,int row, int column) {
		return wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(int SheetIndex,int row, int column) {
		return wb.getSheetAt(SheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(String SheetName,int row, int column) {
		return wb.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();
	}
}
