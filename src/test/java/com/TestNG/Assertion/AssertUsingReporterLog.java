package com.TestNG.Assertion;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertUsingReporterLog {
	
	// only printing testng html report
//	@Test
//	public void AssertionUsningReporter(Method mthd) {
//		SoftAssert assertobj = new SoftAssert(); // using soft asert
//		Reporter.log(mthd.getName() + " Test Run ");
//		Reporter.log("Statement one");
//		Reporter.log("Statement two");
////		Assert.assertEquals("Home", "Home Page");
//		Reporter.log("Statement three");
//		boolean status = true;
//		
//		assertobj.assertEquals("Title", "Title Page"); // title not matched
//		Reporter.log("Statement four");
//		Reporter.log("Statement five");
//		assertobj.assertAll(); // for print exception in console
//		Reporter.log(mthd.getName() + " Test End");
//
//	}
	
	@Test
	public void AssertionUsningReporter(Method mthd) {
		SoftAssert assertobj = new SoftAssert(); // using soft asert
		Reporter.log(mthd.getName() + " Test Run ", true);
		Reporter.log("Statement one",true);
		Reporter.log("Statement two",true);
//		Assert.assertEquals("Home", "Home Page");
		Reporter.log("Statement three",true);
		boolean status = true;
		
		assertobj.assertEquals("Title", "Title Page"); // title not matched
		Reporter.log("Statement four",true);
		Reporter.log("Statement five",true);
		assertobj.assertAll(); // for print exception in console
		Reporter.log(mthd.getName() + " Test End",true);

	}
}
