package com.TestNG.Assertion;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.vtiger.WebDriverUtility.JavaUtility;
import com.vtiger.WebDriverUtility.UtilityClassObject;
import com.vtiger.baseclass.VTigerBaseClass;
import com.vtiger.genericutility.ExcelFile;
import com.vtiger.genericutility.PropertyFile;
import com.vtiger.objectResourceUtility.CreateOrganizationInfo;
import com.vtiger.objectResourceUtility.CreateOrganizationPage;
import com.vtiger.objectResourceUtility.CreatingNewOrganizationPage;
import com.vtiger.objectResourceUtility.Homepage;

@Listeners(com.vtiger.listenerutility.ListenerReportutility.class)
public class CreateOrganizationTest extends VTigerBaseClass {

	PropertyFile pfile = new PropertyFile();
	ExcelFile ef = new ExcelFile();
	JavaUtility ju = new JavaUtility();

	@Test
	public void createOrganization() throws InterruptedException, IOException {

		String orgName = ef.getDataFromExcel("Sheet3", 7, 2) + ju.randomNumber();
		String phoneno = ef.getDataFromExcel("Sheet3", 7, 3);

		UtilityClassObject.getTest().log(Status.INFO, "navigate to organization");
		// navigate to organization
		Homepage hp = new Homepage(driver);
		hp.getorgLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to new organization");
		// navigate to new organization
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.getCreateOrgLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "creating to new organization");
		// creating to new organization
		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.createorganization(orgName, phoneno);

		// verification
		CreateOrganizationInfo coi = new CreateOrganizationInfo(driver);
		String ActualheaderText = coi.getHeaderOrg().getText();

		boolean status = ActualheaderText.contains(orgName);

		// hard assert
		Assert.assertEquals(status, true);
		// Assert.assertEquals(coi.getOrgName().getText().trim(), orgName);

		// soft assert with exception using assertall method
//		SoftAssert assertObj = new SoftAssert();
//		assertObj.assertEquals(coi.getOrgName().getText(), orgName);
//
//		assertObj.assertAll();

		SoftAssert assertObj = new SoftAssert();
		assertObj.assertEquals(coi.getOrgName().getText().trim(), orgName);

		assertObj.assertAll();

	}

}
