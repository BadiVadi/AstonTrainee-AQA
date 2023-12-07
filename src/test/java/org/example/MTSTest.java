package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.example.DriverHelper.driver;

public class MTSTest extends BaseTest {

    @Test
    public void testCheckCommunicationServicesField() {
        WebElement connectionForm = driver.findElement(By.id("pay-connection"));

        WebElement phoneField = connectionForm.findElement(By.id("connection-phone"));
        phoneField.clear();
        phoneField.sendKeys("297777777"); // проверка, что данные отображаются корректно, по аналогии можно сделать и с другими
        System.out.println("Значение номера телефона: " + phoneField.getAttribute("value"));

        WebElement sumField = connectionForm.findElement(By.id("connection-sum"));
        Assertions.assertTrue(sumField.getAttribute("value").isEmpty());
        System.out.println("Значение суммы: " + sumField.getAttribute("value"));

        WebElement emailField = connectionForm.findElement(By.id("connection-email"));
        Assertions.assertTrue(emailField.getAttribute("value").isEmpty());
        System.out.println("Значение e-mail: " + emailField.getAttribute("value"));
    }

    @Test
    public void testCheckHomeInternet() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//button[@class = 'select__header']"));
        dropdown.click();

        ExpectedConditions.visibilityOf(dropdown);
        WebElement homeInternetForm = driver.findElement(By.xpath("//p[text() = 'Домашний интернет']"));
        homeInternetForm.click();

        WebElement phoneField = homeInternetForm.findElement(By.xpath("//input[@id = 'internet-phone']"));
        phoneField.clear();
        phoneField.sendKeys("297777777");
        System.out.println("Значение номера телефона: " + phoneField.getAttribute("value"));

        WebElement sumField = homeInternetForm.findElement(By.xpath("//input[@id = 'internet-sum']"));
        Assertions.assertTrue(sumField.getAttribute("value").isEmpty());
        System.out.println("Значение суммы: " + sumField.getText());

        WebElement emailField = homeInternetForm.findElement(By.xpath("//input[@id = 'internet-email']"));
        Assertions.assertTrue(emailField.getAttribute("value").isEmpty());
        System.out.println("Значение e-mail: " + emailField.getText());
    }
}