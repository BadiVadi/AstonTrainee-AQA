package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.DriverHelper.driver;

public class MTSTest extends BaseTest {

    @Test
    public void testCheckCommunicationServicesField() {
        WebElement cookieAcceptButton = driver.findElement(By.id("cookie-agree"));
        if (cookieAcceptButton.isDisplayed()) {
            cookieAcceptButton.click();
        }
        WebElement connectionForm = driver.findElement(By.id("pay-connection"));

        WebElement phoneField = connectionForm.findElement(By.id("connection-phone"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(phoneField)).sendKeys("297777777"); // проверка, что данные отображаются корректно, по аналогии можно сделать и с другими
        System.out.println("Значение номера телефона: " + phoneField.getAttribute("value"));

        WebElement sumField = connectionForm.findElement(By.id("connection-sum"));
        Assertions.assertTrue(sumField.getAttribute("value").isEmpty());
        System.out.println("Значение суммы: " + sumField.getAttribute("value"));

        WebElement emailField = connectionForm.findElement(By.id("connection-email"));
        Assertions.assertTrue(emailField.getAttribute("value").isEmpty());
        System.out.println("Значение e-mail: " + emailField.getAttribute("value"));
    }

    @Test
    public void testCheckHomeInternet() {
        WebElement cookieAcceptButton = driver.findElement(By.id("cookie-agree"));
        if (cookieAcceptButton.isDisplayed()) {
            cookieAcceptButton.click();
        }
        WebElement dropdown = driver.findElement(By.xpath("//button[@class = 'select__header']"));
        dropdown.click();

        ExpectedConditions.visibilityOf(dropdown);
        WebElement homeInternetForm = driver.findElement(By.xpath("//p[text() = 'Домашний интернет']"));
        homeInternetForm.click();

        WebElement phoneField = homeInternetForm.findElement(By.xpath("//input[@id = 'internet-phone']"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(phoneField)).sendKeys("29777777");
        System.out.println("Значение номера телефона: " + phoneField.getAttribute("value"));

        WebElement sumField = homeInternetForm.findElement(By.xpath("//input[@id = 'internet-sum']"));
        Assertions.assertTrue(sumField.getAttribute("value").isEmpty());
        System.out.println("Значение суммы: " + sumField.getText());

        WebElement emailField = homeInternetForm.findElement(By.xpath("//input[@id = 'internet-email']"));
        Assertions.assertTrue(emailField.getAttribute("value").isEmpty());
        System.out.println("Значение e-mail: " + emailField.getText());
    }

    @Test
    public void testInsatlments() {
        WebElement cookieAcceptButton = driver.findElement(By.id("cookie-agree"));
        if (cookieAcceptButton.isDisplayed()) {
            cookieAcceptButton.click();
        }
        WebElement dropdown = driver.findElement(By.xpath("//button[@class = 'select__header']"));
        dropdown.click();

        ExpectedConditions.visibilityOf(dropdown);
        WebElement instalments = driver.findElement(By.xpath("//p[text() = 'Рассрочка']"));
        instalments.click();

        WebElement scoreField = instalments.findElement(By.xpath("//input[@id ='score-instalment']"));
        ExpectedConditions.visibilityOf(scoreField);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(scoreField)).sendKeys("442543");
        System.out.println("Значение номера счета на 44: " + scoreField.getAttribute("value"));

        WebElement sumField = instalments.findElement(By.xpath("//input[@id = 'instalment-sum']"));
        Assertions.assertTrue(sumField.getAttribute("value").isEmpty());
        System.out.println("Значение суммы: " + sumField.getText());

        WebElement emailField = instalments.findElement(By.xpath("//input[@id ='instalment-email']"));
        Assertions.assertTrue(emailField.getAttribute("value").isEmpty());
        System.out.println("Значение e-mail: " + emailField.getText());
    }

    @Test
    public void testArrear() {
        WebElement cookieAcceptButton = driver.findElement(By.id("cookie-agree"));
        if (cookieAcceptButton.isDisplayed()) {
            cookieAcceptButton.click();
        }
        WebElement dropdown = driver.findElement(By.xpath("//button[@class = 'select__header']"));
        dropdown.click();

        ExpectedConditions.visibilityOf(dropdown);
        WebElement arrear = driver.findElement(By.xpath("//p[text() = 'Задолженность']"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(arrear)).click();

        WebElement scoreField = arrear.findElement(By.xpath("//input[@id = 'score-arrears']"));
        ExpectedConditions.visibilityOf(scoreField);
        scoreField.sendKeys("20737");
        System.out.println("Значение номера счета на 2073: " + scoreField.getAttribute("value"));

        WebElement sumField = arrear.findElement(By.xpath("//input[@id = 'arrears-sum']"));
        Assertions.assertTrue(sumField.getAttribute("value").isEmpty());
        System.out.println("Значение суммы: " + sumField.getText());

        WebElement emailField = arrear.findElement(By.xpath("//input[@id = 'arrears-email']"));
        Assertions.assertTrue(emailField.getAttribute("value").isEmpty());
        System.out.println("Значение e-mail: " + emailField.getText());
    }
    @Test
    public void testFillFieldsAndCheckContinueButton() {
        WebElement cookieAcceptButton = driver.findElement(By.id("cookie-agree"));
        if (cookieAcceptButton.isDisplayed()) {
            cookieAcceptButton.click();
        }

        JavascriptExecutor executor = driver;
        WebElement dropdown = driver.findElement(By.id("pay"));
        executor.executeScript("arguments[0].click();", dropdown);

        WebElement option = driver.findElement(By.xpath("//option[text()='Услуги связи']"));
        option.click();

        WebElement phoneField = driver.findElement(By.id("connection-phone"));
        WebElement sumField = driver.findElement(By.id("connection-sum"));
        WebElement emailField = driver.findElement(By.id("connection-email"));

        phoneField.sendKeys("297777777");
        sumField.sendKeys("10");
        emailField.sendKeys("Badi@gmail.com");

        WebElement continueButton = driver.findElement(By.xpath("//form[@id='pay-connection']//button[text() = 'Продолжить'][1]"));
        continueButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement creditCard = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cc-number")));

        creditCard.clear();
        creditCard.sendKeys("1234567898765432");
        System.out.println("Значение номера карты: " + creditCard.getAttribute("value"));
    }
}