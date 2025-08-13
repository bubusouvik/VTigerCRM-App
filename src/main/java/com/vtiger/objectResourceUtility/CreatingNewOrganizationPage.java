package com.vtiger.objectResourceUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {
	
	WebDriver driver;

	@FindBy(name = "accountname")
	private WebElement OrgName;

	@FindBy(id = "phone")
	private WebElement phone;

	@FindBy(name = "button")
	private WebElement btn;

	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void createorganization(String accname, String number) {
		driver.manage().window().maximize();
		OrgName.sendKeys(accname);
		phone.sendKeys(number);
		btn.click();
	}
}
