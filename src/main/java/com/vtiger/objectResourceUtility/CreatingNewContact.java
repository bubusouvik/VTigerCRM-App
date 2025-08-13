package com.vtiger.objectResourceUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContact {

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@name='account_name']")
	private WebElement orgName;

	@FindBy(xpath = "(//img[@title='Select'])[1]")
	private WebElement plusIcon;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveBtn;

	public CreatingNewContact(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getPlusIcon() {
		return plusIcon;
	}

	public WebElement saveBtn() {
		return saveBtn;
	}

	public void createContact(String organizationName, String lName) {
		lastName.sendKeys(lName);
		orgName.sendKeys(organizationName);
		saveBtn.click();

	}

}
