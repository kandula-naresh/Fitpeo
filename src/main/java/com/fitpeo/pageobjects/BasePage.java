package com.fitpeo.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * BasePage class to handle common web element interactions.
 * This serves as a parent class for all page object classes.
 */

public class BasePage {
	
	 protected WebDriver driver;
	 protected WebDriverWait wait;
	 	
	 
	  //Constructor to initialize WebDriver and WebDriverWait.
	 
	    public BasePage(WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	    
	    //Clicks on a web element identified by the given locator.
	    public void clickElement(By by) {
	    	driver.findElement(by).click();
	    }
	    
	    //Gets the visible text of a web element.
	    public String getElementText(By by) {
	    	return driver.findElement(by).getText();
	    }
	    
	    //Checks if a web element is displayed.
	    public boolean isDisplayed(By by) {
	    	return driver.findElement(by).isDisplayed();
	    }
	    
	    //Enters a keys as a input to Clear the input field
	    public void enterValue(By by, Keys backSpace) {
	    	driver.findElement(by).sendKeys(backSpace);
	    }
	    
	    //Enters a string value into an input field.
	    public void enterValue(By by, String digit) {
	    	driver.findElement(by).sendKeys(digit);
	    }
	    
	    //Waits for a web element to become visible.
	    public void waitForElementToBeVisible(By by) {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	    }
	    
	    // Gets the value of a specified attribute from a web element.
	    public String getAttributeValue(By by, String value) {
	    	return driver.findElement(by).getAttribute(value);
	    }
	    
	    // Scrolls to a specific web element.
	    public void scrollToElement(By by) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
	    }

}
