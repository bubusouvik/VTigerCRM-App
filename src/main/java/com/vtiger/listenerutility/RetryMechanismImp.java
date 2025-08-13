package com.vtiger.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryMechanismImp implements IRetryAnalyzer {
	int start = 0;
	int limitCount = 4;

	@Override
	public boolean retry(ITestResult result) {

		if (start < limitCount) {
			start++;
			return true;
		}

		return false;

	}

}
