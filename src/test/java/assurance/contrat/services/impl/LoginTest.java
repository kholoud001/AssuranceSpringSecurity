package assurance.contrat.services.impl;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\jee\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        //driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void testInvalidLogin() {
        driver.get("http://localhost:8080/contrat_war_exploded/login");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("invalid@gmail.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("invalid");

        // Find and click the login button
        WebElement loginButton = driver.findElement(By.className("login__submit"));
        loginButton.click();


        // After waiting, check the current URL
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:8080/contrat_war_exploded/home";
        boolean isLoggedIn = currentUrl.equals(expectedUrl);

        System.out.println("Login failed, did not redirect to home page " + isLoggedIn);
        assertEquals(isLoggedIn, false, "Login failed, did not redirect to home page.");
    }
















//    @Test
//    public void testInvalidLogin() {
//        driver.get("http://localhost:8080/contrat_war_exploded/login");
//
//        WebElement emailField = driver.findElement(By.name("email"));
//        emailField.sendKeys("invalid.email@example.com"); // Invalid email
//
//        WebElement passwordField = driver.findElement(By.name("password"));
//        passwordField.sendKeys("wrongpassword"); // Invalid password
//
//        // Find and click the login button
//        WebElement loginButton = driver.findElement(By.className("login__submit"));
//        loginButton.click();
//
//        boolean isLoggedIn = !driver.findElements(By.id("home")).isEmpty();
//        System.out.println("is logged in: " + isLoggedIn);
//        assertFalse(isLoggedIn, "Login should have failed but succeeded.");
//    }





}
