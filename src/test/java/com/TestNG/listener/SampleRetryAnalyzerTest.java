package com.TestNG.listener;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.baseclass.VTigerBaseClass;

public class SampleRetryAnalyzerTest extends VTigerBaseClass {

	@Test(retryAnalyzer = com.vtiger.listenerutility.RetryMechanismImp.class)
	public void retrymechanism() {
		System.out.println("stm-1");
		System.out.println("stm-2");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("stm-3");

	}

}
