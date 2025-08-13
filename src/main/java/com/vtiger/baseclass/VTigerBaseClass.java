package com.vtiger.baseclass;

import java.io.IOException;
import java.sql.SQLException;
import java.util.jar.Attributes.Name;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.vtiger.WebDriverUtility.WebDriverUtility;
import com.vtiger.databaseUtility.DatabaseUtility;
import com.vtiger.genericutility.PropertyFile;
import com.vtiger.objectResourceUtility.Homepage;
import com.vtiger.objectResourceUtility.LoginPage;

public class VTigerBaseClass {

	// object class
	public WebDriverUtility wdu = new WebDriverUtility();
	public PropertyFile pfile = new PropertyFile();
	public DatabaseUtility du = new DatabaseUtility();

	public WebDriver driver = null;

	// listener using purpose
	public static WebDriver edriver = null;

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void getDbConnection() throws SQLException {
		System.out.println("Connectin start");
		du.getConnection();
		System.out.println("Db is connected!! ");
	}

//	@Parameters("Browser")
//	@BeforeClass(groups = { "smokeTest", "regressionTest" })
//	public void launchBrowserParallelExecution(String BROWSER) throws IOException {
//
//		String browser = BROWSER;
//		String url = pfile.getFileFromPropertyFile("url");
//
//		if (browser.equals("chrome")) {
//			driver = new ChromeDriver();
//		} else if (browser.equals("firefox")) {
//			driver = new FirefoxDriver();
//		} else if (browser.equals("edge")) {
//			driver = new EdgeDriver();
//		} else {
//			driver = new ChromeDriver();
//		}
//		wdu.timeOutForImplicite(driver);
//		// wdu.screenMaximize(driver);
//		driver.get(url);
//	}

//	@Test(enabled = false)
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void launchBrowser() throws IOException {

//		String browser = pfile.getFileFromPropertyFile("browser");
//		String url = pfile.getFileFromPropertyFile("url");

		// taking data as a parameter using cmd.. run testng.xml via pom.xml
//		String browser = System.getProperty("browser");
//		String url = System.getProperty("url");
		
		//user forgot to pass parameter in cmd then it will take parameter from property file as second arguments by default
		
		String browser = System.getProperty("browser",pfile.getFileFromPropertyFile("browser"));
		String url = System.getProperty("url",pfile.getFileFromPropertyFile("url"));
		
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		wdu.timeOutForImplicite(driver);
		// wdu.screenMaximize(driver);
		driver.get(url);
		// listener using purpose
		edriver = driver;

	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void login() throws IOException {
		
//		String username = pfile.getFileFromPropertyFile("username");
//		String password = pfile.getFileFromPropertyFile("password");
		
		// taking data as a parameter using cmd.. run testng.xml via pom.xml
		
//		String username = System.getProperty("username");
//		String password = System.getProperty("password");
		
		//user forgot to pass parameter in cmd then it will take parameter from property file as second arguments by default
		String username = System.getProperty("username",pfile.getFileFromPropertyFile("username"));
		String password = System.getProperty("password",pfile.getFileFromPropertyFile("password"));
		
		LoginPage lp = new LoginPage(driver);
		lp.getLogin(username, password);

	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void logout() {
		Homepage hp = new Homepage(driver);
		wdu.MoveToElementUsingMouse(driver, hp.getMyPreference());
		hp.getSignOut().click();

	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void closeBrowser() {
		driver.quit();
		System.out.println("Browser is closed!!");
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void closeConnection() throws SQLException {
		du.closeConnection();
		System.out.println("Closed Connection!!");

	}

}
