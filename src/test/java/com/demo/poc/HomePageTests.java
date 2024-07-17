package com.demo.poc;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTests {
    WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        // Set path to chromedriver.exe or other WebDriver executable
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\chilu\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        // Optional: Set headless mode for running tests without opening browser window
        // options.addArguments("--headless");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

   
    @Test
    public void testHomePageContent() {
        // Navigate to the home page of your Angular application
        driver.get("http://localhost:4200/");

        // Wait for the welcome message to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".content h2")));

        // Assert the welcome message content
        String expectedMessage = "Welcome to AIG Synergy";
        String actualMessage = welcomeMessage.getText().trim();
        Assert.assertEquals(actualMessage, expectedMessage, "Welcome message mismatch");
    }
    @AfterClass
    public void teardown() {
        // Close the browser and clean up WebDriver instance
        if (driver != null) {
            //driver.quit();
        }
    }

}