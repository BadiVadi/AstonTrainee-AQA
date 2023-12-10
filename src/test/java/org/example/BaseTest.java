package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.example.DriverHelper.*;

public class BaseTest {

    private static String WB_URL = "https://www.wildberries.ru/";

    @BeforeAll
    public static void setUp() {
        getWebDriver();
        openUrl(WB_URL);
    }

//   @AfterAll
//    public static void close() {
//        System.out.println("Test Close");
//        driver.quit();
//    }
}
