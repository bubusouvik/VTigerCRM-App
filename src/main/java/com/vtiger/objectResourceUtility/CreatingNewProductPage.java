package com.vtiger.objectResourceUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProductPage {

	@FindBy(xpath = "//input[@name='productname']")
	private WebElement productName;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveBtn;

	public CreatingNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void craeteProduct(String pname) {
		productName.sendKeys(pname);
		getSaveBtn().click();
	}
}
