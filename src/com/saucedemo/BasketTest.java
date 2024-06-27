package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BasketTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com");

        // Login
        driver.findElement(By.id("username")).sendKeys("<ValidUN>");
        driver.findElement(By.id("password")).sendKeys("<ValidPass>");
        driver.findElement(By.id("login-button")).click();

        // Positive Test Case
        driver.findElement(By.id("item_01")).click();
        driver.findElement(By.id("item_02")).click();
        driver.findElement(By.id("item_03")).click();

        driver.findElement(By.id("cart_link")).click();        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("<ValidName>");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        
        driver.quit();
    }
}
