package com.fitpeo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FitpeoHomePage extends BasePage{
	
	protected WebDriver driver; 
	
	private By revenueClacButton = By.xpath("//div[contains(text(), 'Revenue Calculator')]");
	
	
	public FitpeoHomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}

	public RevenueCalculatorPage clickOnRevenueCalcPage() {
		clickElement(revenueClacButton);
		return new RevenueCalculatorPage(driver);
	}

}
