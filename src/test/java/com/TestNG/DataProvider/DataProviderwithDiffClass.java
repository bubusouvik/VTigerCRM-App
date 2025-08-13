package com.TestNG.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.vtiger.genericutility.ExcelFile;

public class DataProviderwithDiffClass {

//	@DataProvider(name = "getAllDataInfo")
	public void getDataFromExcel() throws EncryptedDocumentException, IOException {

		ExcelFile efile = new ExcelFile();
		efile.getAllDataInfo("Product");
		System.out.println("hi");

	}

}
//Object[][] objarr = new Object[3][2];
//objarr[0][0] = "iphone";
//objarr[0][1] = "Apple 16";
//objarr[1][0] = "iphone";
//objarr[1][1] = "Apple 14";
//objarr[2][0] = "iphone";
//objarr[2][1] = "Apple 13";
