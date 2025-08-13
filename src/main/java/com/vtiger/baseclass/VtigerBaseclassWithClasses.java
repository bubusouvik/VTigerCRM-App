package com.vtiger.baseclass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.vtiger.WebDriverUtility.WebDriverUtility;
import com.vtiger.genericutility.PropertyFile;
import com.vtiger.objectResourceUtility.Homepage;
import com.vtiger.objectResourceUtility.LoginPage;

public class VtigerBaseclassWithClasses {

	public PropertyFile pfile = new PropertyFile();
	public WebDriverUtility wdu = new WebDriverUtility();

	public WebDriver driver;

	@Parameters("Browser")
	@BeforeClass
	public void launchBrowser(String browser) throws IOException {

//		String BROWSER = browser;
//		if (BROWSER.equals("chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equals("chrome")) {
//			driver = new FirefoxDriver();
//		} else {
//			driver = new EdgeDriver();
//		}
//		wdu.timeOutForImplicite(driver);
//		wdu.screenMaximize(driver);
//		driver.get(pfile.getFileFromPropertyFile("url"));
		System.out.println("Before class !!");
	}

	LoginPage lp = new LoginPage(driver);
	Homepage hp = new Homepage(driver);

	@BeforeMethod
	public void login() throws IOException {
//		String username = pfile.getFileFromPropertyFile("username");
//		String password = pfile.getFileFromPropertyFile("password");
//		lp.getLogin(username, password);
		System.out.println("before method !!");
	}

	@AfterMethod
	public void logout() {
//		wdu.MoveToElementUsingMouse(driver, hp.getMyPreference());
//		hp.getSignOut().click();
		
		System.out.println("after method !!");
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
//		Thread.sleep(5000);
//		driver.quit();
		System.out.println("After class !!");
	}

}
