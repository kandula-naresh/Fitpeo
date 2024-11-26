package com.fitpeo.Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * BaseTest class to handle WebDriver setup and teardown.
 * This class will be extended by all test classes to ensure consistency.
 */
public class BaseTest {

    protected WebDriver driver;

    /**
     * Sets up the WebDriver instance before each test.
     * Includes browser configuration, timeouts, and navigation to the application URL.
     */
    @BeforeTest
    public void setUp() {
        try {
            System.out.println("Initializing WebDriver...");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://fitpeo.com");
            System.out.println("WebDriver setup completed successfully.");
        } catch (Exception e) {
            System.err.println("Error during WebDriver setup: " + e.getMessage());
        }
    }

    /**
     * Quits the WebDriver instance after each test.
     * Ensures all browser instances are closed properly.
     */
    @AfterTest
    public void tearDown() {
        try {
            if (driver != null) {
                System.out.println("Tearing down WebDriver...");
                driver.quit();
                System.out.println("WebDriver teardown completed successfully.");
            }
        } catch (Exception e) {
            System.err.println("Error during WebDriver teardown: " + e.getMessage());
        }
    }
}

