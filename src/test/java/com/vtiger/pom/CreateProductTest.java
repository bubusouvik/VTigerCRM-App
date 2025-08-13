package com.vtiger.pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.WebDriverUtility.JavaUtility;
import com.vtiger.WebDriverUtility.WebDriverUtility;
import com.vtiger.genericutility.PropertyFile;
import com.vtiger.objectResourceUtility.CreateProductLink;
import com.vtiger.objectResourceUtility.CreatingNewProductPage;
import com.vtiger.objectResourceUtility.Homepage;
import com.vtiger.objectResourceUtility.LoginPage;
import com.vtiger.objectResourceUtility.ProductInfoPage;

public class CreateProductTest {

	public static void main(String[] args) throws IOException {

		WebDriverUtility wdu = new WebDriverUtility();
		JavaUtility ju = new JavaUtility();

		PropertyFile pfile = new PropertyFile();
		String browser = pfile.getFileFromPropertyFile("browser");
		String url = pfile.getFileFromPropertyFile("url");
		String username = pfile.getFileFromPropertyFile("username");
		String password = pfile.getFileFromPropertyFile("password");
		String pName = pfile.getFileFromPropertyFile("productname");

		WebDriver driver = null;
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		LoginPage lp = new LoginPage(driver);
		Homepage hp = new Homepage(driver);

		int randomeNo = ju.randomNumber();
		String randomProductName = pName + " " + randomeNo;

		wdu.timeOutForImplicite(driver);
		wdu.screenMaximize(driver);
		driver.get(url);
		lp.getLogin(username, password);

		hp.getProductLink().click();

		CreateProductLink cpl = new CreateProductLink(driver);
		cpl.getCreateProductLink().click();

		CreatingNewProductPage cnpp = new CreatingNewProductPage(driver);
		cnpp.craeteProduct(randomProductName);

		ProductInfoPage pip = new ProductInfoPage(driver);
		String headerText = pip.getheaderProduct().getText();
		if (headerText.contains(randomProductName)) {
			System.out.println(randomProductName + " Product name is verified ==> PASS");
		} else {
			System.out.println(randomProductName + " Product name is not verified ==> FAIL");
		}

	}

}
