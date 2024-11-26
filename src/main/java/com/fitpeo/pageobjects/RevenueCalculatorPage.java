package com.fitpeo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Represents the Revenue Calculator Page and its interactions.
 */

public class RevenueCalculatorPage extends BasePage{
	
	protected WebDriver driver;
	//Locators for various elements on the Revenue Calculator Page
	private By scrollViewElement = By.xpath("//h4[contains(text(), 'Medicare Eligible Patients')]");
	private By textfield = By.xpath("//input[@type='number']");
	private By scrollElement = By.xpath("//input[@type='range']/parent::span");
	private By scrollElementInput = By.xpath("//input[@type='range']");
	private By totalRecurringReimbursement = By.xpath("//p[contains(text(), 'Total Recurring Reimbursement for all Patients Per Month:')]/p");
	private By inspectEle = By.xpath("//p[contains(text(), 'FitPeo Inc')]");
	
	
	//Constructor to initialize the Revenue Calculator Page.
	public RevenueCalculatorPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	//Scrolls to the slider section on the Revenue Calculator Page.
	public void scrollToVisibleSlider() {
		scrollToElement(scrollViewElement);
	}
	
	
	//Adjusts the slider to the specified value.
	public void moveTheSlider(String scrollValue) {
		
		Actions actions = new Actions(driver);
		clickElement(scrollElement);
	    int currentScrollValue = Integer.parseInt(getAttributeValue(scrollElementInput,"value"));
	    int targetScrollValue = Integer.parseInt(scrollValue)-currentScrollValue;

	    for(int i = 0; i <targetScrollValue ; i++) {
	       actions.sendKeys(Keys.ARROW_RIGHT).perform();
	    }
	}
	
	
	//Updates the text field with the specified value.
	public void updateTheTextFeild(String textfieldValue) {
		String currentScrollValue = getAttributeValue(scrollElementInput,"value");
		
		//Clear the current value in the text field
		for(int i=0; i<currentScrollValue.length(); i++) {
			enterValue(textfield, Keys.BACK_SPACE);
		}
		
		// Enter the new value in the text field
		for (char digit : textfieldValue.toCharArray()) {
			enterValue(textfield, String.valueOf(digit));
	    }

	}


	//Selects the specified CPT codes by checking their corresponding checkboxes.
	public void selectCPTCodes(String[] codes) {
	    for (String code : codes) {
	        By checkboxLocator = By.xpath("//p[text()='" + code + "']/following-sibling::label//input[@type='checkbox']");
	        By textLocator = By.xpath("//p[contains(text(), '" + code + "')]");

	        waitForElementToBeVisible(textLocator);
	        scrollToElement(textLocator);
	        clickElement(checkboxLocator);
	    }
	}


	//Retrieves the current value of the slider.
	public String getSliderValue() {
		return getAttributeValue(scrollElementInput,"value");
	}
	
	
	//Retrieves the total recurring reimbursement value displayed on the page.
	public String getTotalReimbursement() {
		waitForElementToBeVisible(inspectEle);
		scrollToElement(inspectEle);
		return getElementText(totalRecurringReimbursement);
	}
	

	//Checks if the Revenue Calculator Page is fully loaded.
	public boolean isPageLoaded() {
		try {
            
			waitForElementToBeVisible(scrollViewElement);
            return isDisplayed(scrollViewElement);
        } catch (Exception e) {
        	System.err.println("Error while checking if the page is loaded: " + e.getMessage());
            return false;
        }
	}

}
