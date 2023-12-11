package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.example.DriverHelper.driver;

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

        WebElement addToBasketItem1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class= 'btn-main']")));
        addToBasketItem1.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement item2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'searchInput']")));
        item2.clear();
        item2.sendKeys("25178529");

        actions.sendKeys(Keys.ENTER).perform();

        WebElement addToBasketItem2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class= 'btn-main']")));
        addToBasketItem2.click();


        WebElement goToBasket = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class ='order']//a[@class]")));
        goToBasket.click();

        // ПОИСК ТОВАРА В КОРЗИНЕ
        WebElement findItems = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='good-info__good-name']")));

        List<WebElement> itemsInBasket = findItems.findElements(By.xpath("//span[@class='good-info__good-name']"));
        StringBuilder itemsInBasketText = new StringBuilder();

        for (WebElement item : itemsInBasket) {
            itemsInBasketText.append(item.getText()).append("\n");
        }
        System.out.println(itemsInBasketText);

        // ПОИСК КОЛИЧЕСТВА ТОВАРА В КОРЗИНЕ
        WebElement itemCounter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'count__wrap']//input")));

        List<WebElement> numberOfItemsInBasket = itemCounter.findElements(By.xpath("//div[@class = 'count__wrap']//input"));
        StringBuilder numberOfItemsInBasketText = new StringBuilder();

        for (WebElement quantity : numberOfItemsInBasket) {
            numberOfItemsInBasketText.append(quantity.getAttribute("value")).append("\n");
        }
        System.out.println(numberOfItemsInBasketText);

        //ПОИСК ЦЕНЫ ТОВАРА В КОРЗИНЕ
        WebElement itemCost = driver.findElement(By.xpath("//div[@class = 'list-item__price-new']"));

        List<WebElement> costOfEachItem = itemCost.findElements(By.xpath("//div[@class = 'list-item__price-new']"));
        StringBuilder costOfEachItemText = new StringBuilder();

        for (WebElement cost : costOfEachItem) {
            costOfEachItemText.append(cost.getAttribute("textContent")).append("\n");
        }
        System.out.println(costOfEachItemText);

        //ОБЩАЯ СТОИМОСТЬ КОРЗИНЫ
        WebElement generalItemsCost = driver.findElement(By.xpath("//div[@class='sidebar__sticky-wrap']//span[@class='b-right']"));
        System.out.println("Общая стоимость товаров: " + generalItemsCost.getAttribute("textContent"));
    }
}