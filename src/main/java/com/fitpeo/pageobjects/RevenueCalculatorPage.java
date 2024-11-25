package com.fitpeo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RevenueCalculatorPage extends BasePage{
	
	protected WebDriver driver;
	
	
	private By scrollViewElement = By.xpath("//h4[contains(text(), 'Medicare Eligible Patients')]");
	private By textfield = By.xpath("//input[@type='number']");
	private By scrollElement = By.xpath("//div[@class='MuiBox-root css-j7qwjs']/span/span[3]");
	private By scrollElementInput = By.xpath("//input[@type='range']");
	
	
	private By checkbox_CPT99091=By.xpath("//p[text()='CPT-99091']/following-sibling::label//input[@type='checkbox']");
	private By checkbox_CPT99453=By.xpath("//p[text()='CPT-99453']/following-sibling::label//input[@type='checkbox']");
	private By checkbox_CPT99454=By.xpath("//p[text()='CPT-99454']/following-sibling::label//input[@type='checkbox']");
	private By checkbox_CPT99474=By.xpath("//p[text()='CPT-99474']/following-sibling::label//input[@type='checkbox']");
	
	private By CPT99091=By.xpath("//p[contains(text(), 'CPT-99091')]");
	private By CPT99453=By.xpath("//p[contains(text(), 'CPT-99453')]");
	private By CPT99454=By.xpath("//p[contains(text(), 'CPT-99454')]");
	private By CPT99474=By.xpath("//p[contains(text(), 'CPT-99474')]");
	
	
	private By TotalRecurringReimbursement = By.xpath("(//p[contains(@class, 'css-1bl0tdj')])[4]");
	
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
	    int currentScrollValue = Integer.parseInt(driver.findElement(scrollElementInput).getAttribute("value"));
	    int targetScrollValue = Integer.parseInt(scrollValue)-currentScrollValue;

	    for(int i = 0; i <targetScrollValue ; i++) {
	       actions.sendKeys(Keys.ARROW_RIGHT).perform();
	    }
	}
	
	
	
	public void updateTheTextFeild(String textfieldValue) {
		int currentScrollValue = Integer.parseInt(driver.findElement(scrollElementInput).getAttribute("value"));
		
		for(int i=0; i<currentScrollValue; i++) {
			//enterValue(textfeild, "Keys.BACK_SPACE");
			driver.findElement(textfield).sendKeys(Keys.BACK_SPACE);
		}
		
		for (char digit : textfieldValue.toCharArray()) {
	        driver.findElement(textfield).sendKeys(String.valueOf(digit));
	    }


//		 driver.findElement(textfeild).sendKeys(Keys.BACK_SPACE);
//		 driver.findElement(textfeild).sendKeys(Keys.BACK_SPACE);
//		 driver.findElement(textfeild).sendKeys(Keys.BACK_SPACE);
//		 driver.findElement(textfeild).sendKeys("5");
//		 driver.findElement(textfeild).sendKeys("6");
//		 driver.findElement(textfeild).sendKeys("0");



	}


	public void SelectCPTCodes() {
		//1
		waitForElementToBeVisible(CPT99091);
		scrollToElement(CPT99091);
		clickElement(checkbox_CPT99091);
		
		//2
		waitForElementToBeVisible(CPT99453);
		scrollToElement(CPT99453);
		clickElement(checkbox_CPT99453);
		
		waitForElementToBeVisible(CPT99454);
		scrollToElement(CPT99454);
		clickElement(checkbox_CPT99454);
		
		waitForElementToBeVisible(CPT99474);
		scrollToElement(CPT99474);
		clickElement(checkbox_CPT99474);
	}


	public String getSliderValue() {
		// TODO Auto-generated method stub
		return driver.findElement(scrollElementInput).getAttribute("value");
	}
	
	public String getText() {
		waitForElementToBeVisible(inspectEle);
		scrollToElement(inspectEle);
		return getElementText(TotalRecurringReimbursement);
	}

}
