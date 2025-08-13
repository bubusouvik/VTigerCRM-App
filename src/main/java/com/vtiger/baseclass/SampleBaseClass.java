package com.vtiger.baseclass;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SampleBaseClass {

	@BeforeSuite
	public void BS() {
		System.out.println("Before Suit");
	}

	@BeforeTest
	public void BT() {
		System.out.println("Before Test");
	}

	@BeforeClass
	public void BC() {
		System.out.println("Before class");
	}

	@BeforeMethod
	public void BM() {
		System.out.println("Before Method");
	}

	@AfterMethod
	public void AM() {
		System.out.println("After Method");
	}

	@AfterClass
	public void AC() {
		System.out.println("After class");
	}

	@AfterTest
	public void AT() {
		System.out.println("After Test");
	}

	@AfterSuite
	public void AS() {
		System.out.println("After Suit");
	}
}
