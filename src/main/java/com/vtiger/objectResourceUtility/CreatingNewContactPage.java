package com.vtiger.objectResourceUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {

	WebDriver driver;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastName;

	@FindBy(id = "department")
	private WebElement department;

	@FindBy(id = "mobile")
	private WebElement mobile;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;

	public CreatingNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getDepartment() {
		return department;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createContact(String lname) {

		lastName.sendKeys(lname);
		getSaveBtn().click();

	}

	public void createContactwithDeptPhn(String lname, String dept, String phno) {

		lastName.sendKeys(lname);
		department.sendKeys(dept);
		mobile.sendKeys(phno);
		getSaveBtn().click();

	}

}
