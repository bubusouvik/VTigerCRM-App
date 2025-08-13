package com.vtiger.organizations;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.genericutility.ExcelFile;
import com.vtiger.genericutility.JsonFile;
import com.vtiger.genericutility.PropertyFile;

public class CreateOrganizations {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

		// object creation
		PropertyFile pFile = new PropertyFile();
		JsonFile jf = new JsonFile();
		ExcelFile ef = new ExcelFile();

		// using property file
		String browser = pFile.getFileFromPropertyFile("browser");
		String url = pFile.getFileFromPropertyFile("url");
		String username = pFile.getFileFromPropertyFile("username");
		String password = pFile.getFileFromPropertyFile("password");

		// using json file
//		String browser = jf.getDataFromJsonFile("browser");
//		String url = jf.getDataFromJsonFile("url");
//		String username = jf.getDataFromJsonFile("username");
//		String passwrd = jf.getDataFromJsonFile("password");
//		String password = jf.getDataFromJsonFile("password");

		Random random = new Random();
		int randomIndex = random.nextInt(1000);

		// using excel file
		String orgName = ef.getDataFromExcel("Sheet3", 1, 2) + randomIndex;

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
		Thread.sleep(1500);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(orgName);
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();

		// verify header last name
		String headerCompany = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerCompany.contains(orgName)) {
			System.out.println(orgName + " Header portion company name = pass");
		} else {
			System.out.println(orgName + " Header portion company name = fail");
		}
		// verify last name text filed
		String actualCompanyRes = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actualCompanyRes.trim().equals(orgName)) {
			System.out.println(orgName + " is created = pass");
		} else {
			System.out.println(orgName + " is created = fail");
		}

		Thread.sleep(5000);
		driver.quit();

	}

}
