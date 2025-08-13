package com.vtiger.pom;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vtiger.WebDriverUtility.JavaUtility;
import com.vtiger.WebDriverUtility.WebDriverUtility;
import com.vtiger.genericutility.ExcelFile;
import com.vtiger.genericutility.PropertyFile;
import com.vtiger.objectResourceUtility.ContactInfoPage;
import com.vtiger.objectResourceUtility.CreateContactPage;
import com.vtiger.objectResourceUtility.CreateOrganizationPage;
import com.vtiger.objectResourceUtility.CreatingNewContact;
import com.vtiger.objectResourceUtility.CreatingNewOrganizationPage;
import com.vtiger.objectResourceUtility.FetchOrganizationPage;
import com.vtiger.objectResourceUtility.Homepage;
import com.vtiger.objectResourceUtility.LoginPage;

public class CreateContactWithorganizationTest {

	public static void main(String[] args) throws IOException, InterruptedException {

		//from property file 
		PropertyFile pfile = new PropertyFile();
		// from excel file
		ExcelFile ef = new ExcelFile();
		//from java utility file
		JavaUtility ju = new JavaUtility();
		//from webdriverutility file
		WebDriverUtility wdu = new WebDriverUtility();

		String browser = pfile.getFileFromPropertyFile("browser");
		String url = pfile.getFileFromPropertyFile("url");
		String username = pfile.getFileFromPropertyFile("username");
		String password = pfile.getFileFromPropertyFile("password");
		String lastname = pfile.getFileFromPropertyFile("lastname");

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
		wdu.screenMaximize(driver);
		driver.get(url);
		wdu.timeOutForImplicite(driver);
		Thread.sleep(1500);

		// following business logic
		LoginPage lp = new LoginPage(driver);
		lp.getLogin(username, password);

		Homepage hp = new Homepage(driver);
		hp.getorgLink().click();

		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.getCreateOrgLink().click();

		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.createorganization(orgName, phoneno);

		Thread.sleep(3000);
		hp.getContactLink().click();
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getCreateContact().click();

		CreatingNewContact cnc = new CreatingNewContact(driver);
		cnc.getPlusIcon().click();

		wdu.switchToAnotherTab(driver, "module=Accounts&action");

		FetchOrganizationPage fop = new FetchOrganizationPage(driver);
		fop.getOrgName(orgName, driver);

		wdu.switchToAnotherTab(driver, "module=Contacts&action");

		cnc.createContact(orgName, lastname);

		ContactInfoPage cip = new ContactInfoPage(driver);
		String headeText = cip.getheaderContact().getText();

		if (headeText.contains(lastname)) {
			System.out.println("Contact name is verified ==> PASS ");
		} else {
			System.out.println("Contact name is not verified ==> Fail ");
		}

		Thread.sleep(6000);
		driver.quit();
	}

}
