package com.vtiger.objectResourceUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FetchOrganizationPage {

	@FindBy(id = "search_txt")
	private WebElement searchOrg;

	@FindBy(xpath = "//input[@type='button']")
	private WebElement searchBtn;

	public FetchOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchOr() {
		return searchOrg;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public void getOrgName(String orgName, WebDriver driver) {
		searchOrg.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[.='" + orgName + "']")).click();

	}

}
