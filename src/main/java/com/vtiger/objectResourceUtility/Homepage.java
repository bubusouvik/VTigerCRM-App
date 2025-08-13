package com.vtiger.objectResourceUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	WebDriver driver;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	@FindBy(linkText = "Sign Out")
	private WebElement signout;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement MyPreferece;

	@FindBy(linkText = "Contacts")
	private WebElement contactLink;

	@FindBy(linkText = "Products")
	private WebElement productsLink;

	public WebElement getorgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getProductLink() {
		return productsLink;
	}

	public WebElement getMyPreference() {
		return MyPreferece;
	}

	public WebElement getSignOut() {
		return signout;
	}

}
