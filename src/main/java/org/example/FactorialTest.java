package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTest {

    @Test
    void testCalculateFactorial() {
        int input = 5;
        int expectedOutput = 120;
        int resultOutput = Factorial.calculateFactorial(input);
        Assert.assertEquals(resultOutput, expectedOutput, "Ошибочный расчет");
    }
}
