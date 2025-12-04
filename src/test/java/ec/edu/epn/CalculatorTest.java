package ec.edu.epn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ec.edu.epn.Calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;



public class CalculatorTest {

    private Calculator calc;
    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calc = null;
    }


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
    public void testDivideByZero_ThrowsException() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> calc.divide(5, 0));
    }

    @Test
    public void testIsEven() {
        assertTrue(calc.isEven(4));
        assertFalse(calc.isEven(3));
        assertTrue(calc.isEven(0));
        assertTrue(calc.isEven(-2));
    }

    @ParameterizedTest
    @CsvSource({
        "1,2,3",
        "5,7,12",
        "1,-2,-1"
    })

    public void testAddParameterized(int a, int b, int expected) {
        assertEquals(expected, calc.add(a, b));
    }
    
    @Test
void divide_DosNumerosPositivos_retornaCocienteCorrecto() {
    // Arrange
    int a = 10;
    int b = 2;

    // Act
    double result = calc.divide(a, b);

    // Assert
    assertAll(
        () -> assertEquals(5.0, result, "El cociente debería ser 5.0"),
        () -> assertTrue(result > 0, "El resultado debe ser positivo")
    );
}



}