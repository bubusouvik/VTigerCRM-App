package com.TestNG.listener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.baseclass.VTigerBaseClass;

//@Listeners(com.vtiger.listenerutility.ContactListenerImp.class)
public class CreateContactTest extends VTigerBaseClass {

	@Test
	public void createContact() {

		System.out.println("Statement one");
		System.out.println("Statement two");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("Statement three");
		System.out.println("Statement four");

	}

}
