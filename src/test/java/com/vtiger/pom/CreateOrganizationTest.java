package com.vtiger.pom;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.WebDriverUtility.JavaUtility;
import com.vtiger.genericutility.ExcelFile;
import com.vtiger.genericutility.PropertyFile;
import com.vtiger.objectResourceUtility.CreateContactPage;
import com.vtiger.objectResourceUtility.CreateOrganizationInfo;
import com.vtiger.objectResourceUtility.CreateOrganizationPage;
import com.vtiger.objectResourceUtility.CreatingNewOrganizationPage;
import com.vtiger.objectResourceUtility.Homepage;
import com.vtiger.objectResourceUtility.LoginPage;

public class CreateOrganizationTest {

	public static void main(String[] args) throws IOException, InterruptedException {

		PropertyFile pfile = new PropertyFile();
		ExcelFile ef = new ExcelFile();
		JavaUtility ju = new JavaUtility();

		String browser = pfile.getFileFromPropertyFile("browser");
		String url = pfile.getFileFromPropertyFile("url");
		String username = pfile.getFileFromPropertyFile("username");
		String password = pfile.getFileFromPropertyFile("password");

		String orgName = ef.getDataFromExcel("Sheet3", 7, 2) + ju.randomNumber();
		String phoneno = ef.getDataFromExcel("Sheet3", 7, 3);

		WebDriver driver = null;

		if (browser.equals("chrome")) {

			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {

			driver = new FirefoxDriver();

		} else {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Thread.sleep(1500);

		// following business logic
		LoginPage lp = new LoginPage(driver);
		lp.getLogin(username, password);

		// not following business logic
//		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
//		login.getUsername().sendKeys(username);
//		login.getPassword().sendKeys(password);
//		login.getButton().click();

		Homepage hp = new Homepage(driver);
		hp.getorgLink().click();

		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.getCreateOrgLink().click();

		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.createorganization(orgName, phoneno);

		CreateOrganizationInfo coi = new CreateOrganizationInfo(driver);
		String headerText = coi.getHeaderOrg().getText();
		if (headerText.contains(orgName)) {
			System.out.println("Text is verified = Pass");
		} else {
			System.out.println("Text is not verified = Fail");
		}

		

		Thread.sleep(10000);
		driver.quit();

	}

}
