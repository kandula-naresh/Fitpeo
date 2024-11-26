package com.fitpeo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Represents the Fitpeo Home Page and its interactions.
 */
public class FitpeoHomePage extends BasePage{
	
	protected WebDriver driver; 
	
	// Locator for the Revenue Calculator button
	private By revenueClacButton = By.xpath("//div[contains(text(), 'Revenue Calculator')]");
	
	// Constructor to initialize the Fitpeo Home Page.
	public FitpeoHomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}
	
	
	//Clicks on the Revenue Calculator button and navigates to the Revenue Calculator page.
	public RevenueCalculatorPage clickOnRevenueCalcPage() {
		clickElement(revenueClacButton);
		return new RevenueCalculatorPage(driver);
	}

}
