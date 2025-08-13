package com.TestNG.Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.WebDriverUtility.WebDriverUtility;

public class DataDrivenWithAmazon {

	WebDriverUtility wdu = new WebDriverUtility();

	@Test(dataProvider = "getProduct")
	public void createProduct(String productbrand, String productname) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		wdu.screenMaximize(driver);
		wdu.timeOutForImplicite(driver);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productbrand, Keys.ENTER);

		String x = "//span[.='" + productname
				+ "']/../../../../div[3]/div/div/div/div[1]/div[1]/a/span[1]/span[2]/span[2]";
		String productPrice = driver.findElement(By.xpath(x)).getText();
		System.out.println("product name ==> " + productname + " price ==> " + productPrice);

		Thread.sleep(8000);
		driver.quit();
	}

	@DataProvider
	public Object[][] getProduct() {

		Object[][] prdctarr = new Object[3][2];

		prdctarr[0][0] = "iphone";
		prdctarr[0][1] = "iPhone 16 Pro Max 256 GB: 5G Mobile Phone with Camera Control, 4K 120 fps Dolby Vision and a Huge Leap in Battery Life. Works with AirPods; Desert Titanium";
		prdctarr[1][0] = "iphone";
		prdctarr[1][1] = "iPhone 16 Pro 256 GB: 5G Mobile Phone with Camera Control, 4K 120 fps Dolby Vision and a Huge Leap in Battery Life. Works with AirPods; Black Titanium";
		prdctarr[2][0] = "iphone";
		prdctarr[2][1] = "iPhone 16 128 GB: 5G Mobile Phone with Camera Control, A18 Chip and a Big Boost in Battery Life. Works with AirPods; Black";

		return prdctarr;

	}

}
