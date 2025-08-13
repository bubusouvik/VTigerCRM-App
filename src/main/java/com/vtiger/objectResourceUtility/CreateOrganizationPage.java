package com.vtiger.objectResourceUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {

	WebDriver driver;

	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createorgLink;

	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchFor;

	@FindBy(id = "bas_searchfield")
	private WebElement searchField;

	@FindBy(xpath = "(//input[@value=' Search Now '])[1]")
	private WebElement searchNowBtn;

	public CreateOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public WebElement getCreateOrgLink() {
		return createorgLink;
	}

	public WebElement getSearchFor() {
		return searchFor;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getsearchNowBtn() {
		return searchNowBtn;
	}
}
