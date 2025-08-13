package com.vtiger.contact;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.WebDriverUtility.JavaUtility;
import com.vtiger.WebDriverUtility.WebDriverUtility;
import com.vtiger.genericutility.ExcelFile;
import com.vtiger.genericutility.PropertyFile;

public class CreateContactWithorganization {

	public static void main(String[] args) throws IOException, InterruptedException {

		// Create Object
		WebDriverUtility wdu = new WebDriverUtility();

		PropertyFile pfile = new PropertyFile();
		String browser = pfile.getFileFromPropertyFile("browser");
		String url = pfile.getFileFromPropertyFile("url");
		String username = pfile.getFileFromPropertyFile("username");
		String password = pfile.getFileFromPropertyFile("password");
		String lastname = pfile.getFileFromPropertyFile("lastname");

		ExcelFile ef = new ExcelFile();
		JavaUtility ju = new JavaUtility();

		String lName = lastname + ju.randomNumber();
		String orgName = ef.getDataFromExcel("Sheet3", 4, 2) + ju.randomNumber();

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
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1500);
		wdu.timeOutForImplicite(driver);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(1500);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		Thread.sleep(1200);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		Thread.sleep(1200);
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lName);
		driver.findElement(By.xpath("//input[@name = 'account_name']/following-sibling::img")).click();

		// switch to child window
		wdu.switchToAnotherTab(driver, "module=Accounts");

		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// switch to parent window
		wdu.switchToAnotherTab(driver, "module=Contacts");

		String urlanother = driver.getCurrentUrl();
		if (urlanother.contains("module=Contacts")) {
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		}

		String HeaderLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		String lastName = driver.findElement(By.id("mouseArea_Last Name")).getText();

		if (HeaderLastName.contains(lName)) {
			System.out.println(lName + " header portion is pass");
		} else {
			System.out.println(lName + " header portion is fail");
		}
		if (lastName.trim().equals(lName)) {
			System.out.println(lName + " last name is verified pass");
		} else {
			System.out.println(lName + " last name is verified fail");
		}
	}

}
