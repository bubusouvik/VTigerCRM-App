package com.vtiger.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.vtiger.baseclass.VTigerBaseClass;

public class ContactListenerImp implements ITestListener, ISuiteListener {

	@Override
	public void onTestSuccess(ITestResult res) {
		System.out.println("==== Exceution start ==== " + res.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult res) {
		System.out.println(res.getMethod().getMethodName() + "==== Exceution start ====");
		String date = new Date().toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ts = (TakesScreenshot) VTigerBaseClass.edriver;
		String test = res.getMethod().getMethodName();
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/" + test + date + ".png");
		try {
//			FileUtils.copyFile(src, dest);
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
