package com.vtiger.testngwithbaseclass;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.vtiger.WebDriverUtility.JavaUtility;
import com.vtiger.WebDriverUtility.WebDriverUtility;
import com.vtiger.baseclass.VTigerBaseClass;
import com.vtiger.genericutility.ExcelFile;
import com.vtiger.genericutility.PropertyFile;
import com.vtiger.objectResourceUtility.ContactInfoPage;
import com.vtiger.objectResourceUtility.CreateContactPage;
import com.vtiger.objectResourceUtility.CreateOrganizationInfo;
import com.vtiger.objectResourceUtility.CreateOrganizationPage;
import com.vtiger.objectResourceUtility.CreatingNewContact;
import com.vtiger.objectResourceUtility.CreatingNewOrganizationPage;
import com.vtiger.objectResourceUtility.FetchOrganizationPage;
import com.vtiger.objectResourceUtility.Homepage;

public class CreateOrgWithBaseClassTest extends VTigerBaseClass {

	ExcelFile efile = new ExcelFile();
	JavaUtility ju = new JavaUtility();
	WebDriverUtility wdu = new WebDriverUtility();
	PropertyFile pfile = new PropertyFile();

	@Test(groups = "smokeTest")
	public void createOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {

		String organizationName = efile.getDataFromExcelNew("Sheet3", 4, 2);
		String phoneno = efile.getDataFromExcelNew("Sheet3", 7, 3);
		String orgName = organizationName + ju.randomNumber();
		Homepage hp = new Homepage(driver);
		hp.getorgLink().click();

		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.getCreateOrgLink().click();

		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.createorganization(orgName, phoneno);

		CreateOrganizationInfo coi = new CreateOrganizationInfo(driver);
		String headerText = coi.getHeaderOrg().getText();
		if (headerText.contains(orgName)) {
			System.out.println(orgName + " Organization is verified ==> PASS");
		} else {
			System.out.println(orgName + " Organization is not verified ==> FAIL");
		}

	}

	@Test(groups = "regressionTest")
	public void createOrgWithPhoneTest() throws InterruptedException, EncryptedDocumentException, IOException {

		String organizationName = efile.getDataFromExcelNew("Sheet3", 4, 2);
		String phoneno = efile.getDataFromExcelNew("Sheet3", 7, 3);
		String orgName = organizationName + ju.randomNumber();
		String lastname = pfile.getFileFromPropertyFile("lastname");

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
	}

	@Test(groups = "regressionTest")
	public void deleteOrgTest() throws EncryptedDocumentException, IOException {

		String orgName = efile.getDataFromExcelNew("Sheet3", 7, 2) + ju.randomNumber();
		String phoneno = efile.getDataFromExcelNew("Sheet3", 7, 3);

		Homepage hp = new Homepage(driver);
		hp.getorgLink().click();

		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.getCreateOrgLink().click();

		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.createorganization(orgName, phoneno);

		CreateOrganizationInfo coi = new CreateOrganizationInfo(driver);
		String headerText = coi.getHeaderOrg().getText();
		if (headerText.contains(orgName)) {
			System.out.println(orgName + " Organization is verified ==> PASS");
		} else {
			System.out.println(orgName + " Organization is not verified ==> FAIL");
		}

		// go back to organization page

		hp.getorgLink().click();
		cop.getSearchFor().sendKeys(orgName);

		wdu.searchDD(cop.getSearchField(), "Organization Name");

		cop.getsearchNowBtn().click();

		driver.findElement(By.xpath("//a[.='" + orgName + "']/../../td[8]/a[.='del']")).click();

		wdu.simpleAlertAccept(driver);

	}

}
