package com.vtiger.contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.WebDriverUtility.JavaUtility;
import com.vtiger.genericutility.PropertyFile;

public class CreateContactWithSupportStartEndDate {

	public static void main(String[] args) throws IOException, InterruptedException {

		// create object
		JavaUtility ju = new JavaUtility();
		PropertyFile pfile = new PropertyFile();
		
		
		
		String browser = pfile.getFileFromPropertyFile("browser");
		String url = pfile.getFileFromPropertyFile("url");
		String username = pfile.getFileFromPropertyFile("username");
		String password = pfile.getFileFromPropertyFile("password");
		String lastname = pfile.getFileFromPropertyFile("lastname");

		String lname = lastname + ju.randomNumber();

		WebDriver driver = null;

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(1500);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(1200);
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lname);
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(ju.getTodayDateWithFormatyyyyMMdd());
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(ju.expectedDateWithFormatyyyyMMdd(30));

		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
//
		// verify header last name
		String headerPortion = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerPortion.contains(lname)) {
			System.out.println(lname + " Header last name portion is pass");
		} else {
			System.out.println(lname + " Header last name portion is fail");
		}
		// verify last name text filed
		String actualRes = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		if (actualRes.contains(lname)) {
			System.out.println(lname + " is created = pass");
		} else {
			System.out.println(lname + " is created = fail");
		}
		// verify firstdate date
		String sdate = driver.findElement(By.id("mouseArea_Support Start Date")).getText();
		if (sdate.trim().equals(ju.getTodayDateWithFormatyyyyMMdd())) {
			System.out.println(ju.getTodayDateWithFormatyyyyMMdd() + " start date is verified => pass");
		} else {
			System.out.println(ju.getTodayDateWithFormatyyyyMMdd() + " start date is verified => fail");
		}
		// verify firstdate date
		String ldate = driver.findElement(By.id("mouseArea_Support End Date")).getText();
		if (ldate.trim().equals(ju.expectedDateWithFormatyyyyMMdd(0))) {
			System.out.println(ju.expectedDateWithFormatyyyyMMdd(30) + " last date is verified => pass");
		} else {
			System.out.println(ju.expectedDateWithFormatyyyyMMdd(30) + " last date is verified => fail");
		}

//		Thread.sleep(12000);
//		driver.quit();

	}

}
