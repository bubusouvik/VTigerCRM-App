package com.vtiger.objectResourceUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactInfoPage {

	WebDriver driver;
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement HeaderInfo;

	public CreateContactInfoPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderInfo() {
		return HeaderInfo;
	}

}
