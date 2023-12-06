package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import static org.example.DriverHelper.driver;

public class MTSTest extends BaseTest {

    MTSPage mtsPage = new MTSPage();

    @Test
    public void testOnlineRechargeBlock() {
        mtsPage.printHeader();
    }

    @Test
    public void testCheckLogos() {
        WebElement logosContainer = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".pay__partners ul")));

        List<WebElement> logos = logosContainer.findElements(By.tagName("img"));

        String[] expectedAltTexts = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт", "МИР"};

        for (int i = 0; i < logos.size(); i++) {
            WebElement logo = logos.get(i);
            String actualAltText = logo.getAttribute("alt");
            String expectedAltText = expectedAltTexts[i];
            System.out.println("Ожидаемый результат:" + expectedAltText + "\n" + "Реальный результат: " + actualAltText);
        }
    }

    @Test
    public void testMoreInformationButton() {
        WebElement linkByHref = driver.findElement(By.xpath("//a[contains(text(), 'о сервисе')]"));
        String hrefText = linkByHref.getText();
        Actions actions = new Actions(driver);
        actions.moveToElement(linkByHref).click().perform();
        System.out.println("Элемент с текстом: " + hrefText + " найден");
    }

    @Test
    public void testFillFieldsAndCheckContinueButton() {

        JavascriptExecutor executor = driver;
        WebElement dropdown = driver.findElement(By.id("pay"));
        executor.executeScript("arguments[0].click();", dropdown);

        WebElement option = driver.findElement(By.xpath("//option[text()='Услуги связи']"));
        option.click();

        WebElement phoneField = driver.findElement(By.id("connection-phone"));
//        WebElement sumField = driver.findElement(By.id("connection-sum"));
//        WebElement emailField = driver.findElement(By.id("connection-email"));

        phoneField.clear();

        phoneField.sendKeys("297777777");

        WebElement continueButton = driver.findElement(By.xpath("//form[@id='pay-connection']//button[text() = 'Продолжить'][1]"));
        continueButton.click();
    }
}