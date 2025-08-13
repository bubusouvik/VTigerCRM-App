package com.vtiger.objectResourceUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductLink {

	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createProductLink;

	public CreateProductLink(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateProductLink() {
		return createProductLink;
	}
}
