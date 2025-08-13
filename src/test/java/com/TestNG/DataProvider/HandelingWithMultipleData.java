package com.TestNG.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HandelingWithMultipleData {

	@Test(dataProvider = "getMobileInfo")
	public void createMobileTest(String mobilename, String brand) {

		System.out.println("Mobile ====> " + mobilename + " brand ===> " + brand);
	}

	@DataProvider
	public Object[][] getMobileInfo() {

		Object[][] objarr = new Object[3][2];
		objarr[0][0] = "Samsung";
		objarr[0][1] = "A30";
		objarr[1][0] = "Samsung";
		objarr[1][1] = "B10";
		objarr[2][0] = "Samsung";
		objarr[2][1] = "C10";

		return objarr;

	}

}
