package com.fitpeo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class RevenueCalculatorPage extends BasePage{
	
	protected WebDriver driver;
	
	private By scrollViewElement = By.xpath("//h4[contains(text(), 'Medicare Eligible Patients')]");
	private By textfield = By.xpath("//input[@type='number']");
	private By scrollElement = By.xpath("//div[@class='MuiBox-root css-j7qwjs']/span/span[3]");
	private By scrollElementInput = By.xpath("//input[@type='range']");
	private By totalRecurringReimbursement = By.xpath("(//p[contains(@class, 'css-1bl0tdj')])[4]");
	private By inspectEle = By.xpath("//p[contains(text(), 'FitPeo Inc')]");
	
	
	
	public RevenueCalculatorPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	
	public void scrollToVisibleSlider() {
		scrollToElement(scrollViewElement);
	}
	
	
	
	public void moveTheSlider(String scrollValue) {
		
		Actions actions = new Actions(driver);
		clickElement(scrollElement);
	    int currentScrollValue = Integer.parseInt(getAttributeValue(scrollElementInput,"value"));
	    int targetScrollValue = Integer.parseInt(scrollValue)-currentScrollValue;

	    for(int i = 0; i <targetScrollValue ; i++) {
	       actions.sendKeys(Keys.ARROW_RIGHT).perform();
	    }
	}
	
	
	
	public void updateTheTextFeild(String textfieldValue) {
		int currentScrollValue = Integer.parseInt(getAttributeValue(scrollElementInput,"value"));
		
		for(int i=0; i<currentScrollValue; i++) {
			enterValue(textfield, Keys.BACK_SPACE);
		}
		
		for (char digit : textfieldValue.toCharArray()) {
			enterValue(textfield, String.valueOf(digit));
	    }



	}



	public void selectCPTCodes(String[] codes) {
	    for (String code : codes) {
	        By checkboxLocator = By.xpath("//p[text()='" + code + "']/following-sibling::label//input[@type='checkbox']");
	        By textLocator = By.xpath("//p[contains(text(), '" + code + "')]");

	        waitForElementToBeVisible(textLocator);
	        scrollToElement(textLocator);
	        clickElement(checkboxLocator);
	    }
	}



	public String getSliderValue() {
		return getAttributeValue(scrollElementInput,"value");
	}
	
	public String getTotalReimbursement() {
		waitForElementToBeVisible(inspectEle);
		scrollToElement(inspectEle);
		return getElementText(totalRecurringReimbursement);
	}


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
