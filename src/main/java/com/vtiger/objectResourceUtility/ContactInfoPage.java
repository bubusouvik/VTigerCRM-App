package com.vtiger.objectResourceUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerContact;

	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public WebElement getheaderContact() {
		return headerContact;
	}

}
