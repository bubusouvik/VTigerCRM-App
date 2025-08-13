package com.vtiger.objectResourceUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {

	WebDriver driver;

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContact;

	public CreateContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContact() {
		return createContact;
	}
	

}
