package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class MTSTest extends WebDriver {

    @Test
    public void testOnlineRechargeBlock() {
        driver.get("https://www.mts.by/");
        WebElement onlineRechargeHeader = driver.findElement(By.cssSelector("section.pay h2"));

        String headerText = onlineRechargeHeader.getText();
        System.out.println("Заголовок: " + headerText);
    }

    @Test
    public void testCheckLogos() {
        driver.get("https://www.mts.by/");

        WebElement logosContainer = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".pay__partners ul")));

        List<WebElement> logos = logosContainer.findElements(By.tagName("img"));

        String[] expectedAltTexts = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт", "МИР"};

        for (int i = 0; i < logos.size(); i++) {
            WebElement logo = logos.get(i);
            String actualAltText = logo.getAttribute("alt");
            String expectedAltText = expectedAltTexts[i];

        }
    }

    @Test
    public void testMoreInformationButton() {
        driver.get("https://www.mts.by/");
        WebElement linkByHref = driver.findElement(By.xpath("//a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(linkByHref).click().perform();
    }

    @Test
    public void testFillFieldsAndCheckContinueButton() {
        driver.get("https://www.mts.by/");

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement dropdown = driver.findElement(By.id("pay"));
        executor.executeScript("arguments[0].click();", dropdown);

        WebElement option = driver.findElement(By.xpath("//option[text()='Услуги связи']"));
        option.click();


        WebElement phoneField = driver.findElement(By.id("connection-phone"));
        WebElement sumField = driver.findElement(By.id("connection-sum"));
        WebElement emailField = driver.findElement(By.id("connection-email"));

        phoneField.clear();

        phoneField.sendKeys("297777777");

        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection button[type='submit']"));
        executor.executeScript("arguments[0].click();", continueButton);

    }
}