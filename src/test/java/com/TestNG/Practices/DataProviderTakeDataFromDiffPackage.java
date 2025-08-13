package com.TestNG.Practices;

import org.testng.annotations.Test;

import com.TestNG.DataProvider.DataProviderwithDiffClass;

public class DataProviderTakeDataFromDiffPackage {

	@Test(dataProviderClass = DataProviderwithDiffClass.class, dataProvider = "getDataInfo")
	public void infoTest(String brandname, String productname) {

		System.out.println("Brand name ==> " + brandname + " product name ==> " + productname);

	}

}
