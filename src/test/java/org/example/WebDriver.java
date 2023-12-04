package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriver {
    protected static ChromeDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Test Start");
    }

    @AfterAll
    public static void close() {
        System.out.println("Test Close");
        driver.quit();
    }
}

