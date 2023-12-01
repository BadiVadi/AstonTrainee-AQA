package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    @Test
    void testCalculateFactorial() {
        assertEquals(120, Factorial.calculateFactorial(5));
    }
}
