package com.TestNG.Practices;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.genericutility.ExcelFile;

public class DataDrivenTekPyramidWithExcel {

	ExcelFile efile = new ExcelFile();

	@Test(dataProvider = "getDataFromExcel")
	public void getDataFromExcelTest(String StudentName, String branchName, String advSel, String restassured,
			String java, String api, String manual) {

		System.out.println(StudentName + "\t" + branchName + "\t" + advSel + "\t\t" + restassured + "\t\t" + java + "\t" + api
				+ "\t" + manual);
	}

	@DataProvider
	public Object[][] getDataFromExcel() throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("./testappdata/TeckPyramid.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Scanner sc = new Scanner(System.in);
		System.out.print("Please provide your sheet name here ===> ");
		String sheet = sc.next();
		Sheet sheetname = wb.getSheet(sheet);
		int rowCount = sheetname.getLastRowNum();

		Row row = sheetname.getRow(0);
		short cellcount = row.getLastCellNum();

		Object[][] objarr = new Object[rowCount][cellcount];
		for (int i = 0; i < rowCount; i++) {
			Row sheetrow = sheetname.getRow(i);
			for (int j = 0; j < cellcount; j++) {
				Cell cel = sheetrow.getCell(j);
				objarr[i][j] = cel.toString();

			}
		}
		return objarr;
	}

}
