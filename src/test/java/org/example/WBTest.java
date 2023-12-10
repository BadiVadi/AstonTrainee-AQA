package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.DriverHelper.driver;
import static org.example.DriverHelper.getWebDriver;

public class WBTest extends BaseTest {
//    WBPage wbPage = new WBPage();

    @Test
    public void chooseItemsFromCatalog() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Слип на 5 секунд, чтобы страница загрузилась полнолстью
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement item1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'searchInput']")));

        Actions actions = new Actions(driver);

        item1.clear();
        item1.sendKeys("9449222");

        actions.sendKeys(Keys.ENTER).perform();

        WebElement addToBasketitem1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class= 'btn-main']")));
        addToBasketitem1.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement item2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'searchInput']")));
        item2.clear();
        item2.sendKeys("25178529");

        actions.sendKeys(Keys.ENTER).perform();

        WebElement addToBasketitem2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class= 'btn-main']")));
        addToBasketitem2.click();


        WebElement goToBasket = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class ='navbar-pc__icon navbar-pc__icon--basket']")));
        goToBasket.click();
    }
}