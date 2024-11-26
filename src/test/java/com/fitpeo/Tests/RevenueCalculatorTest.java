package com.fitpeo.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fitpeo.pageobjects.FitpeoHomePage;
import com.fitpeo.pageobjects.RevenueCalculatorPage;

public class RevenueCalculatorTest extends BaseTest{
	FitpeoHomePage HomePage;
	RevenueCalculatorPage revenueCalcPage;
	
	 /**
     * Test navigating to the Revenue Calculator page.
     */
	@Test(priority=1)
	public void testNavigateToRevenueCalculatorPage() {
		
		HomePage = new FitpeoHomePage(driver);
		
		//Navigate to Revenue Calculator Page
		revenueCalcPage= HomePage.clickOnRevenueCalcPage();
		
		//Navigation verification to the Revenue Calculator Page
		Assert.assertTrue(revenueCalcPage.isPageLoaded(), "Revenue Calculator page did not load correctly.");
		
	}
	

    /**
     * Test slider adjustment to the value 820.
     */
	
	@Test(priority=2)
	public void testSliderAdjustmentTo820() {
		
		// Scroll to slider section
		revenueCalcPage.scrollToVisibleSlider();
		
		 // Adjust the slider to the desired value
		String sliderValue ="820";
		revenueCalcPage.moveTheSlider(sliderValue);
		
		 // Validate the slider's value
		String scrollValue820 = revenueCalcPage.getSliderValue();
		Assert.assertEquals(scrollValue820, sliderValue, "The slider value does not match.");
		
	}
		
	/**
     * Test validating slider value after updating the text field.
     */
	@Test(priority=3)
	public void testValidateSliderValueAfterTextUpdate() {
		
		// Update the text field with a value
		String TextfeildValue = "560";
		revenueCalcPage.updateTheTextFeild(TextfeildValue);
		
		// Validate the slider's value matches the updated text field value
		String scrollValue = revenueCalcPage.getSliderValue();
		Assert.assertEquals(scrollValue, TextfeildValue, "The slider value does not match the text field value.");

	}
	
	/**
     * Test selecting CPT codes.
     */
	
	@Test(priority=4)
	public void testSelectCPTCodes() {
	
		// Set slider value as a prerequisite for CPT codes
		revenueCalcPage.moveTheSlider("820");
		
		// Select multiple CPT codes
		String[] cptCodes = {"CPT-99091", "CPT-99453", "CPT-99454", "CPT-99474"};
		revenueCalcPage.selectCPTCodes(cptCodes);
		
		System.out.println("CPT codes selected successfully.");
		
	}
	
	
    /*
      	Test validating the total recurring reimbursement.
     */
	
	@Test(priority=5)
	public void testValidateTotalRecurringReimbursement() {
		
		// Expected reimbursement value
		String expectedReimbursement = "$110700";
		
		// Total Recurring Reimbursement for all Patients Per Month = $110700
        Assert.assertEquals(revenueCalcPage.getTotalReimbursement(), expectedReimbursement, "Reimbursement mismatch!");
		
	}

}
