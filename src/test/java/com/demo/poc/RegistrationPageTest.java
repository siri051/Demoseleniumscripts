package com.demo.poc;

import java.time.Duration;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationPageTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\chilu\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testRegistration() {
        // Navigate to registration page
        driver.get("http://localhost:4200/register"); // Replace with your registration page URL

        // Fill out registration form
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement phoneInput = driver.findElement(By.id("phone"));
        WebElement ageInput = driver.findElement(By.id("age"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement confirmPasswordInput = driver.findElement(By.id("confirmPassword"));
        WebElement registerButton = driver.findElement(By.xpath("//button[@type='submit']"));

        usernameInput.sendKeys("user3");
        emailInput.sendKeys("user3@example.com");
        phoneInput.sendKeys("1234567890");
        ageInput.sendKeys("30");
        passwordInput.sendKeys("password");
        confirmPasswordInput.sendKeys("password");

        Actions actions = new Actions(driver);
        actions.moveToElement(registerButton).click().perform();

        // registerButton.click();
        // Scroll to the element
        // ((JavascriptExecutor)
        // driver).executeScript("arguments[0].scrollIntoView(true);", registerButton);
        // // Click the element
        // wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();

        // Assertion to verify successful registration message or navigate to login page
        // WebElement successMessage =
        // driver.findElement(By.xpath("//p[contains(text(),'Registration
        // successful!')]"));
        // Assert.assertTrue(successMessage.isDisplayed());
        // Wait for alert to be present
        // Wait for either success message or alert

        // Wait for success message or handle alert

        // Handle alert immediately if it appears
        // handleAlertIfExists();

        // Wait for success message
        // try {
        // WebElement successMessage = wait.until(ExpectedConditions
        // .visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Registration
        // successful!')]")));
        // Assert.assertTrue(successMessage.isDisplayed());
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        if (alert != null) {
            if (alert.getText().contains("Registration successful!")) {
                alert.accept(); // Dismiss the alert
                System.out.println("Registration successful!");
            }
        }
        // } catch (TimeoutException e) {
        // throw new RuntimeException("Registration failed: Timeout waiting for success
        // message.");
        // }
    }

    // private void handleAlertIfExists() {
    // try {
    // Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    // if (alert != null) {
    // if (alert.getText().contains("User already exists!")) {
    // alert.accept(); // Dismiss the alert
    // System.out.println("User already exists!");
    // throw new RuntimeException("Registration failed: User already exists.");
    // } else {
    // throw new RuntimeException("Unexpected alert opened: " + alert.getText());
    // }
    // }
    // } catch (TimeoutException e) {
    // // Alert not present, continue with registration process
    // }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
