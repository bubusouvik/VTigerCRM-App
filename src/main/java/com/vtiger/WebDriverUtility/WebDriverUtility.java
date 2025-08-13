package com.vtiger.WebDriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void screenMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void timeOutForImplicite(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForVisibleElement(WebDriver driver, WebElement ele) {
		WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(20));
		wdw.until(ExpectedConditions.visibilityOf(ele));
	}

	public void searchDD(WebElement ele, String text) {
		Select dropdown = new Select(ele);
		dropdown.selectByVisibleText(text);
	}

	public void switchToAnotherTab(WebDriver driver, String partialUrl) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			String title = driver.getCurrentUrl();
			if (title.contains(partialUrl)) {
				break;
			}
		}

	}

	public void simpleAlertAccept(WebDriver driver) {

		driver.switchTo().alert().accept();

	}

	public void simpleAlertDismiss(WebDriver driver) {

		driver.switchTo().alert().dismiss();

	}

	public void MoveToElementUsingMouse(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void DoubleClickUsingMouse(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void MoveByOffSet(WebDriver driver, int x, int y) {
		Actions action = new Actions(driver);
		action.moveByOffset(x, y);
	}

	public void javascriptExceuter(WebDriver driver, WebElement ele) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementByid(ele).value='souvik'", ele);
	}

	public void takesScreenshotToEntireElement(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./target/p1.png");
		FileHandler.copy(src, dest);
	}

	public void takesScreenshotToElement(WebElement ele) throws IOException {
		File src = ele.getScreenshotAs(OutputType.FILE);
		File dest = new File("./target/p1.png");
		FileHandler.copy(src, dest);
	}

}
