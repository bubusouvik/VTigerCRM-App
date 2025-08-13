package com.vtiger.genericutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelFile {
	
	
	public Object[][] getAllDataInfo(String sheetName) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("./testappdata/vTigerExcel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int rowc = sheet.getLastRowNum();
		Row rowfirst = sheet.getRow(0);
		int cellc = rowfirst.getPhysicalNumberOfCells();
		Object[][] objarr = new Object[rowc][cellc];
		for (int i = 0; i < rowc; i++) {
			Row row = sheet.getRow(i + 1);
			int cellCount = row.getPhysicalNumberOfCells();
			for (int j = 0; j < cellCount; j++) {
				Cell cell = row.getCell(j);
				objarr[i][j] = cell.toString();
			}
		}
		return objarr;
	}

	public String getDataFromExcelNew(String sheetName, int rowNum, int colNum)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("./testappdata/VtigerOrg.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
		return data;
	}
	public String getDataFromExcel(String sheetName, int rowNum, int colNum)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("./testappdata/VtigerOrg.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
		return data;
	}

	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testappdata/vTigerExcel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		return rowCount;

	}

	public int getCellCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testappdata/TeckPyramid.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Row row = wb.getSheet(sheetName).getRow(0);
		int cellCount = row.getPhysicalNumberOfCells();
		return cellCount;
	}

	public String getDataFromExcel(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testappdata/TeckPyramid.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetname);
		int rowCount = sheet.getLastRowNum();
		String cellValue = "";
		for (int i = 0; i < rowCount; i++) {
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(i);
			cellValue = cell.getStringCellValue();

		}
		return cellValue;
	}

}
