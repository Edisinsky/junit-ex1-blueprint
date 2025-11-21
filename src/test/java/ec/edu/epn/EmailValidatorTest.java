package ec.edu.epn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ec.edu.epn.EmailValidator;

public class EmailValidatorTest {

    private EmailValidator emailValidator;

    static Stream<Arguments> emailValidatorData(){
        Stream<Arguments> ret =
        Stream.of(
            Arguments.of("christian@example.com",true),
            Arguments.of("christian.suarez@example.com",true),
            Arguments.of("correo.invalido",false),
            Arguments.of("null",false)
        );
        return ret;
    }

    @BeforeEach
    public void setUp(){
        emailValidator = new EmailValidator();
    }

    @ParameterizedTest
    @MethodSource("emailValidatorData")
    void isValid_MultipleEmails_ShouldReturnTrue(String email, boolean expected){ 
        //Act
        boolean result = emailValidator.isValid(email);

        //Assert
        assertEquals(expected, result);
    }
}
