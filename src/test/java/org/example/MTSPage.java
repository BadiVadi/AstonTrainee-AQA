package org.example;

import org.openqa.selenium.By;

import static org.example.DriverHelper.driver;

public class MTSPage {

    public static String header = driver.findElement(By.cssSelector("section.pay h2")).getText();

    public MTSPage printHeader() {
        System.out.println("Заголовок: " + header);
        return this;
    }
}