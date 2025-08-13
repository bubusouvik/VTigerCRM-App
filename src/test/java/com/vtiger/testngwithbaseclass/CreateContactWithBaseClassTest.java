package com.vtiger.testngwithbaseclass;

import java.io.IOException;

import org.testng.annotations.Test;

import com.vtiger.WebDriverUtility.WebDriverUtility;
import com.vtiger.baseclass.VTigerBaseClass;
import com.vtiger.databaseUtility.DatabaseUtility;
import com.vtiger.genericutility.ExcelFile;
import com.vtiger.genericutility.PropertyFile;
import com.vtiger.objectResourceUtility.CreateContactInfoPage;
import com.vtiger.objectResourceUtility.CreateContactPage;
import com.vtiger.objectResourceUtility.CreatingNewContactPage;
import com.vtiger.objectResourceUtility.Homepage;

public class CreateContactWithBaseClassTest extends VTigerBaseClass {

	DatabaseUtility du = new DatabaseUtility();
	PropertyFile pfile = new PropertyFile();
	ExcelFile efile = new ExcelFile();
	WebDriverUtility wdu = new WebDriverUtility();

	@Test(groups = "smokeTest")
	public void createContactTest() throws IOException {

		// navigating
		Homepage hp = new Homepage(driver);
		hp.getContactLink().click();

		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getCreateContact().click();

		// test script
		String lastname = pfile.getFileFromPropertyFile("lastname");
		CreatingNewContactPage cnp = new CreatingNewContactPage(driver);
		cnp.createContact(lastname);

		// verified
		CreateContactInfoPage ccip = new CreateContactInfoPage(driver);
		String header = ccip.getHeaderInfo().getText();
		if (header.contains(lastname)) {
			System.out.println("Last name is verified " + lastname + " ===> PASS");
		} else {
			System.out.println("Last name is not verified " + lastname + " ===> FAIL");
		}

	}

	@Test(groups = "regressionTest")
	public void createContactWithDeptPhoneTest() throws IOException {

		// navigating
		Homepage hp = new Homepage(driver);
		hp.getContactLink().click();
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getCreateContact().click();

		// test script
		String lastname = pfile.getFileFromPropertyFile("lastname");
		String department = pfile.getFileFromPropertyFile("department");
		CreatingNewContactPage cnp = new CreatingNewContactPage(driver);
		cnp.createContactwithDeptPhn(lastname, department, "9734325673");

		// verified
		CreateContactInfoPage ccip = new CreateContactInfoPage(driver);
		String header = ccip.getHeaderInfo().getText();
		if (header.contains(lastname)) {
			System.out.println("Last name is verified " + lastname + " ===> PASS");
		} else {
			System.out.println("Last name is not verified " + lastname + " ===> FAIL");
		}

	}
}
