package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class OrderTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Add items to the cart until the total is between $30 and $60
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        driver.findElement(By.className("shopping_cart_link")).click();

        // Check total amount
        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        BigDecimal total = BigDecimal.ZERO;

        for (WebElement priceElement : prices) {
            String priceText = priceElement.getText().substring(1); // Remove "$"
            BigDecimal price = new BigDecimal(priceText);
            total = total.add(price);
        }

        if (total >= 30 && total <= 60) {
            System.out.println("Total value is between $30 and $60. Test passed");
        } else {
            System.out.println("Total value is not between $30 and $60. Test failed");
        }

        driver.findElement(By.id("checkout")).click();

        // Complete the checkout process
        driver.findElement(By.id("first-name")).sendKeys("TestUserName");
        driver.findElement(By.id("last-name")).sendKeys("TestUserLastName");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();

        driver.quit();
    }
}
