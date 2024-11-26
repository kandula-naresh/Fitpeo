package com.fitpeo.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fitpeo.pageobjects.FitpeoHomePage;
import com.fitpeo.pageobjects.RevenueCalculatorPage;

public class RevenueCalculatorTest extends BaseTest{
	FitpeoHomePage HomePage;
	RevenueCalculatorPage revenueCalcPage;
	
	@Test(priority=1)
	public void testNavigateToRevenueCalculatorPage() {
		
		HomePage = new FitpeoHomePage(driver);
		
		//Navigate to the Revenue Calculator Page:
		revenueCalcPage= HomePage.clickOnRevenueCalcPage();
		
		Assert.assertTrue(revenueCalcPage.isPageLoaded(), "Revenue Calculator page did not load correctly.");
		
	}
	
	
	@Test(priority=2)
	public void testSliderAdjustmentTo820() {
		
		//Scroll Down to the Slider section:
		revenueCalcPage.scrollToVisibleSlider();
		
		//Adjust the Slider:
		String sliderValue ="820";
		revenueCalcPage.moveTheSlider(sliderValue);
		
	}
		
	@Test(priority=3)
	public void testValidateSliderValueAfterTextUpdate() {
		
		//Update the Text Field:
		String TextfeildValue = "560";
		revenueCalcPage.updateTheTextFeild(TextfeildValue);
		
		//Validate Slider Value
		String scrollValue = revenueCalcPage.getSliderValue();
		Assert.assertEquals(scrollValue, TextfeildValue, "The slider value does not match the text field value.");

	}
	
	@Test(priority=4)
	public void testSelectCPTCodes() {
	
		//Select CPT Codes:
		revenueCalcPage.moveTheSlider("820");
		
		String[] cptCodes = {"CPT-99091", "CPT-99453", "CPT-99454", "CPT-99474"};
		revenueCalcPage.selectCPTCodes(cptCodes);
		
	}
	@Test(priority=5)
	public void testValidateTotalRecurringReimbursement() {
		
		//Validate total reimbursement
		String expectedReimbursement = "$110700";
        Assert.assertEquals(revenueCalcPage.getTotalReimbursement(), expectedReimbursement, "Reimbursement mismatch!");
		
	}

}
