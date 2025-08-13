package com.TestNG.Assertion;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractices {

//  @Test
//	public void HomePageTest(Method mthd) { // failed using hardassert
//		System.out.println(mthd.getName() + " Test Run ");
//		System.out.println("Statement one");
//		System.out.println("Statement two");
//		System.out.println("Statement three");
//		Assert.assertEquals("Home", "Home Page");// actual results and expected results is not matched..
//		System.out.println("Statement four");
//		System.out.println("Statement five");
//		System.out.println(mthd.getName() + " Test End");
//	}
	@Test
	public void HomePageTest(Method mthd) { // passed using hardassert
		System.out.println(mthd.getName() + " Test Run ");
		System.out.println("Statement one");
		System.out.println("Statement two");
		System.out.println("Statement three");
		Assert.assertEquals("Home", "Home"); //// actual results and expected results is matched..
		System.out.println("Statement four");
		System.out.println("Statement five");
		System.out.println(mthd.getName() + " Test End");
	}

	@Test
	public void HomePageTitleTest(Method mthd) {
		SoftAssert assertobj = new SoftAssert(); // using soft asert
		System.out.println(mthd.getName() + " Test Run ");
		System.out.println("Statement one");
		System.out.println("Statement two");
		System.out.println("Statement three");
		boolean status = true;
		assertobj.assertEquals("Title", "Title Page"); // title not matched
		System.out.println("Statement four");
		System.out.println("Statement five");
		assertobj.assertAll(); // for print exception in console
		System.out.println(mthd.getName() + " Test End");
		
	}

}
