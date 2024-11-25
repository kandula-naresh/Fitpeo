package com.fitpeo.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fitpeo.pageobjects.FitpeoHomePage;
import com.fitpeo.pageobjects.RevenueCalculatorPage;

public class RevenueCalculatorTest extends BaseTest{
	
	@Test
	public void testRevenueCalculator() throws InterruptedException {
		
		FitpeoHomePage HomePage = new FitpeoHomePage(driver);
		
		RevenueCalculatorPage revenueCalcPage= HomePage.clickOnRevenueCalcPage();
		
		revenueCalcPage.scrollToVisibleSlider();
	
		revenueCalcPage.moveTheSlider("820");
		
		
		String TextfeildValue = "560";
		
		revenueCalcPage.updateTheTextFeild(TextfeildValue);
		
		String scrollValue = revenueCalcPage.getSliderValue();
		
		Assert.assertEquals(TextfeildValue, scrollValue);
		
		revenueCalcPage.moveTheSlider("820");
		
		revenueCalcPage.SelectCPTCodes();
		
		String actualTotalRecurringReimbursement = "$110700";
        String TotalRecurringReimbursement = revenueCalcPage.getText();
        Assert.assertEquals(TotalRecurringReimbursement, actualTotalRecurringReimbursement);
        
        System.out.println("success");

		
		
		
	}

}
