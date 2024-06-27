package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class LoginTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "geckodriver_path");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com");

        // Positive Test Case
        driver.findElement(By.id("username")).sendKeys("<ValidUN>");
        driver.findElement(By.id("password")).sendKeys("<ValidPass>");
        driver.findElement(By.id("login-button")).click();

        String currentUrl = driver.getCurrentUrl();
        if ("https://www.saucedemo.com/inventory.html".equals(currentUrl)) {
            System.out.println("Login test Successfully");
        } else {
            System.out.println("Login test failed!");
        }
        driver.quit();
    }
}
