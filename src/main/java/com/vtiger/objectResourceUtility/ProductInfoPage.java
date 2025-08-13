package com.vtiger.objectResourceUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement headerProduct;

	public ProductInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getheaderProduct() {
		return headerProduct;
	}

}
