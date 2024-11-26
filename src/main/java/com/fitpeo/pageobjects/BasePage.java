package com.fitpeo.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	 protected WebDriver driver;
	 protected WebDriverWait wait;

	    public BasePage(WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	    
	    public void clickElement(By by) {
	    	driver.findElement(by).click();
	    }
	    
	    public String getElementText(By by) {
	    	return driver.findElement(by).getText();
	    }
	    
	    public boolean isDisplayed(By by) {
	    	return driver.findElement(by).isDisplayed();
	    }
	    
	    public void enterValue(By by, Keys backSpace) {
	    	driver.findElement(by).sendKeys(backSpace);
	    }
	    
	    public void enterValue(By by, String digit) {
	    	driver.findElement(by).sendKeys(digit);
	    }
	    
	    public void waitForElementToBeVisible(By by) {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	    }
	    
	    public String getAttributeValue(By by, String value) {
	    	return driver.findElement(by).getAttribute(value);
	    }
	    
	    public void scrollToElement(By by) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
	    }

}
