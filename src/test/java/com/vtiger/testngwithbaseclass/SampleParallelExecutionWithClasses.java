package com.vtiger.testngwithbaseclass;

import java.io.IOException;

import org.testng.annotations.Test;

import com.vtiger.baseclass.VtigerBaseclassWithClasses;
import com.vtiger.genericutility.PropertyFile;
import com.vtiger.objectResourceUtility.CreateContactPage;
import com.vtiger.objectResourceUtility.CreatingNewContactPage;
import com.vtiger.objectResourceUtility.Homepage;

public class SampleParallelExecutionWithClasses extends VtigerBaseclassWithClasses {

	@Test
	public void createContact() throws IOException {

//		Homepage hp = new Homepage(driver);
//		hp.getContactLink().click();
//		CreateContactPage ccp = new CreateContactPage(driver);
//		ccp.getCreateContact();
//		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
//		PropertyFile pfile = new PropertyFile();
//		cncp.createContact(pfile.getFileFromPropertyFile("lastname"));
		
		System.out.println("Test method !!");

	}
}
