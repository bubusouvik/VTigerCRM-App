package com.TestNG.Practices;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.WebDriverUtility.WebDriverUtility;
import com.vtiger.genericutility.ExcelFile;

public class DataDrivenAmazonWithExcel {
	WebDriverUtility wdu = new WebDriverUtility();
	ExcelFile efile = new ExcelFile();

	@Test(dataProvider = "getproductPrice")
	public void getProduct(String pband, String pname) {

		WebDriver driver = new ChromeDriver();
		wdu.timeOutForImplicite(driver);
		wdu.screenMaximize(driver);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(pband, Keys.ENTER);
		String x = "//span[.='"+pname+"']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']";
		String productPrice = driver.findElement(By.xpath(x)).getText();
		System.out.println("product name ==> " + pname + " price ==> " + productPrice);

	}

	@DataProvider
	public Object[][] getproductPrice() throws EncryptedDocumentException, IOException {
		int rowcount = efile.getRowCount("Product");
		Object[][] objArr = new Object[rowcount][2];

		for (int i = 0; i < rowcount; i++) {
			objArr[i][0] = efile.getDataFromExcel("Product", i + 1, 0);
			objArr[i][1] = efile.getDataFromExcel("Product", i + 1, 1);

		}
		return objArr;
	}

}
