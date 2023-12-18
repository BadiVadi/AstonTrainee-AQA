package org.example;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.example.DriverHelper.driver;

public class WBTest extends BaseTest {

    @Test
    public void chooseItemsFromCatalog() {
        addStep("Выбор товара из каталога");

        waitPageLoaded();

        WebElement item1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'searchInput']")));
        item1.clear();
        item1.sendKeys("9449222");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();

        WebElement addToBasketItem1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class= 'btn-main']")));
        addToBasketItem1.click();

        waitPageLoaded();

        WebElement item2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'searchInput']")));
        item2.clear();
        item2.sendKeys("25178529");

        actions.sendKeys(Keys.ENTER).perform();

        WebElement addToBasketItem2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class= 'btn-main']")));
        addToBasketItem2.click();

        WebElement goToBasket = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class ='order']//a[@class]")));
        goToBasket.click();

        addStep("Определение товара в корзине");
        verifyItemsInBasket();

        addStep("Определение количества и стоимости каждого товара");
        verifyQuantityAndCost();

        addStep("Определение общей стоимости товара");
        verifyTotalCost();
    }
    @Step("{stepDescription}")
    private void addStep(String stepDescription) {
        Allure.addAttachment("Step", stepDescription);
    }

    private void verifyItemsInBasket() {
        WebElement findItems = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='good-info__good-name']")));
        List<WebElement> itemsInBasket = findItems.findElements(By.xpath("//span[@class='good-info__good-name']"));
        StringBuilder itemsInBasketText = new StringBuilder();
        for (WebElement item : itemsInBasket) {
            itemsInBasketText.append(item.getText()).append("\n");
        }

        Assertions.assertTrue(itemsInBasketText.length() > 0, "Добавленные товары в корзину");
    }

    private void verifyQuantityAndCost() {
        WebElement itemCounter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'count__wrap']//input")));
        List<WebElement> numberOfItemsInBasket = itemCounter.findElements(By.xpath("//div[@class = 'count__wrap']//input"));
        StringBuilder numberOfItemsInBasketText = new StringBuilder();
        for (WebElement quantity : numberOfItemsInBasket) {
            numberOfItemsInBasketText.append(quantity.getAttribute("value")).append("\n");
        }

        WebElement itemCost = driver.findElement(By.xpath("//div[@class = 'list-item__price-new']"));
        List<WebElement> costOfEachItem = itemCost.findElements(By.xpath("//div[@class = 'list-item__price-new']"));
        StringBuilder costOfEachItemText = new StringBuilder();
        for (WebElement cost : costOfEachItem) {
            costOfEachItemText.append(cost.getAttribute("textContent")).append("\n");
        }

        Assertions.assertTrue(numberOfItemsInBasketText.length() > 0, "Количество товара в корзине");
        Assertions.assertTrue(costOfEachItemText.length() > 0, "Стоимость каждого товара в корзине");
    }

    private void verifyTotalCost() {
        WebElement generalItemsCost = driver.findElement(By.xpath("//div[@class='sidebar__sticky-wrap']//span[@class='b-right']"));
        String totalCostText = generalItemsCost.getAttribute("textContent");

        Assertions.assertTrue(totalCostText.length() > 0, "Общая стоимость");
    }
}