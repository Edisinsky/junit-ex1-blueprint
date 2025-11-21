package ec.edu.epn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

public class TaxCalculatorTest {
    
    private TaxCalculator taxCalculator;

    @BeforeEach
    void setUp() {
        taxCalculator = new TaxCalculator();
    }

 static Stream<Arguments> taxCalculatorData() {
      return  Stream.of(
            Arguments.of(1000.0, 0.15, 150.0),
            Arguments.of(2000.0, 0.10, 200.0),
            Arguments.of(0.0, 0.20, 0.0),
            Arguments.of(500.0, 0.0, 0.0)
        );
    }

    @ParameterizedTest
    @MethodSource("taxCalculatorData")
    void calculateTax_MultipleValues_ShouldReturnExpected(double valor, double impuesto, double expected) {
        // Act
        double result = taxCalculator.calculateTax(valor, impuesto);

        // Assert
        assertEquals(expected, result, 1e-9);
    }

   

}
