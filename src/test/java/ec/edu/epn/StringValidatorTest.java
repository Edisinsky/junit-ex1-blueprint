package ec.edu.epn;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringValidatorTest {

    private static class TestData {
        String input;
        boolean expected;

        TestData(String input, boolean expected) {
            this.input = input;
            this.expected = expected;
        }
    }

    @TestFactory
    Collection<DynamicTest> dynamicPalindromeTests() {
        StringValidator stringValidator = new StringValidator();

        List<TestData> testDataList = Arrays.asList(
            new TestData("reconocer", true),
            new TestData("oso", true),
            new TestData("hola", false)
        );

        return testDataList.stream()
            .map(data ->
                DynamicTest.dynamicTest(
                    "isPalindrome('" + data.input + "') debe ser " + data.expected,
                    () -> {
                        boolean result = stringValidator.isPalindrome(data.input);
                        assertEquals(data.expected, result);
                    }
                )
            )
            .collect(Collectors.toList());
    }
}
