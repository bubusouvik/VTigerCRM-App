package com.vtiger.listenerutility;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class BasicSampleImplement implements ITestListener, ISuiteListener {

	public void onStart(ISuite res) {
		System.out.println("onstart");
	}

	public void onFinish(ISuite res) {
		System.out.println("onfinish");
	}

	public void onTestStart(ITestResult res) {
		System.out.println("onStartTest" + res.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult res) {
		System.out.println("onTestFailure" + res.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult res) {
		System.out.println("onTestSuccess" + res.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult res) {
		System.out.println("onTestSkipped" + res.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult res) {
		System.out.println("onTestFailButWithinSuccessPercentage" + res.getMethod().getMethodName());
	}

	public void onTestFailedWithTimeout(ITestResult res) {
		System.out.println("onTestFailedWithTimeout" + res.getMethod().getMethodName());
	}

}
