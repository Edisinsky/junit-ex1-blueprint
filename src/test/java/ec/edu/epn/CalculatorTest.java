package ec.edu.epn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5, calc.add(2, 3));
        assertEquals(-1, calc.add(2, -3));
        assertEquals(0, calc.add(0, 0));
    }

    @Test
    public void testSubtract() {
        assertEquals(-1, calc.subtract(2, 3));
        assertEquals(5, calc.subtract(2, -3));
        assertEquals(0, calc.subtract(0, 0));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calc.multiply(2, 3));
        assertEquals(0, calc.multiply(0, 5));
        assertEquals(-6, calc.multiply(2, -3));
    }

    @Test
    public void testDivide() {
        assertEquals(2.5, calc.divide(5, 2), 1e-9);
        assertEquals(-2.0, calc.divide(4, -2), 1e-9);
        assertEquals(0.0, calc.divide(0, 5), 1e-9);
    }

     @Test
    public void testDivideByZero() {
        // For JUnit 5, use assertThrows to check for exceptions
        Assertions.assertThrows(IllegalArgumentException.class, () -> calc.divide(5, 0));
    }

    @Test
    public void testIsEven() {
        assertTrue(calc.isEven(4));
        assertFalse(calc.isEven(3));
        assertTrue(calc.isEven(0));
        assertTrue(calc.isEven(-2));
    }
}