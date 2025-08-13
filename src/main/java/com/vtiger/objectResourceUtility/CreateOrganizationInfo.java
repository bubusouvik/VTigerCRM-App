package com.vtiger.objectResourceUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationInfo {
	WebDriver driver;

	@FindBy(className = "dvHeaderText")
	private WebElement HeaderOrg;

	@FindBy(id = "mouseArea_Organization Name")
	private WebElement orgFieldValue;

	public CreateOrganizationInfo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderOrg() {
		return HeaderOrg;
	}

	public WebElement getOrgName() {
		return orgFieldValue;
	}

}
