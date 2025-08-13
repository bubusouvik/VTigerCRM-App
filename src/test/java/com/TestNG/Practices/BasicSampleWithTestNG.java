package com.TestNG.Practices;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.baseclass.SampleBaseClass;

@Listeners(com.vtiger.listenerutility.BasicSampleImplement.class)
public class BasicSampleWithTestNG extends SampleBaseClass {

	@Test
	public void BasicSample() {
		System.out.println("Basic First TestCase !!");
	}

	@Test
	public void TestSample() {
		System.out.println("Basic Second TestCase");
		Assert.assertEquals("Home", "Login");
		System.out.println("Basic Third TestCase");
	}

	@Test(dependsOnMethods = "TestSample")
	public void NewSample() {
		System.out.println("New Sample !!");
	}
}
