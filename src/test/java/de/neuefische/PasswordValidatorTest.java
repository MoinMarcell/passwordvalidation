package de.neuefische;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void hasMinimumLengthOfEightCharacters_expectTrue() {
        // GIVEN
        String password = "12345678";
        // WHEN
        boolean actual = PasswordValidator.hasMinimumLengthOfEightCharacters(password);
        // THEN
        assertTrue(actual);
    }

    @Test
    void hasMinimumLengthOfEightCharacters_expectFalse() {
        // GIVEN
        String password = "1234567";
        // WHEN
        boolean actual = PasswordValidator.hasMinimumLengthOfEightCharacters(password);
        // THEN
        assertFalse(actual);
    }

    @Test
    void includesAtLeastOneDigit_expectTrue() {
        // GIVEN
        String password = "asd3g5sd5";
        // WHEN
        boolean actual = PasswordValidator.includesAtLeastOneDigit(password);
        // THEN
        assertTrue(actual);
    }

    @Test
    void includesAtLeastOneDigit_expectFalse() {
        // GIVEN
        String password = "asdgsdsdf";
        // WHEN
        boolean actual = PasswordValidator.includesAtLeastOneDigit(password);
        // THEN
        assertFalse(actual);
    }

    @Test
    void hasAtLeastOneUppercaseLetter_expectTrue() {
        // GIVEN
        String password = "aSd3g5sd5";
        // WHEN
        boolean actual = PasswordValidator.hasAtLeastOneUppercaseLetter(password);
        // THEN
        assertTrue(actual);
    }

    @Test
    void hasAtLeastOneUppercaseLetter_expectFalse() {
        // GIVEN
        String password = "asd3g5sd5";
        // WHEN
        boolean actual = PasswordValidator.hasAtLeastOneUppercaseLetter(password);
        // THEN
        assertFalse(actual);
    }

    @Test
    void hasAtLeastOneLowercaseLetter_expectTrue() {
        // GIVEN
        String password = "asd3g5sd5";
        // WHEN
        boolean actual = PasswordValidator.hasAtLeastOneLowercaseLetter(password);
        // THEN
        assertTrue(actual);
    }

    @Test
    void hasAtLeastOneLowercaseLetter_expectFalse() {
        // GIVEN
        String password = "ASDASDF3ASF5";
        // WHEN
        boolean actual = PasswordValidator.hasAtLeastOneLowercaseLetter(password);
        // THEN
        assertFalse(actual);
    }

    @Test
    void hasAtLeastOneSpecialCharacter_expectTrue() {
        // GIVEN
        String password = "asd3g5sd5!";
        // WHEN
        boolean actual = PasswordValidator.hasAtLeastOneSpecialCharacter(password);
        // THEN
        assertTrue(actual);
    }

    @Test
    void hasAtLeastOneSpecialCharacter_expectFalse() {
        // GIVEN
        String password = "asd3g5sd5";
        // WHEN
        boolean actual = PasswordValidator.hasAtLeastOneSpecialCharacter(password);
        // THEN
        assertFalse(actual);
    }

    @ParameterizedTest
    @CsvSource({
            "12345678",
            "password",
            "123456789",
            "1234567890",
            "qwertyuiop",
            "test",
            "1234567",
            "123456",
            "12345",
            "1234",
            "123",
            "12",
            "1",
            "p",
            "pa",
            "pas",
            "pass",
            "passw",
            "passwo",
            "passwor",
            "qwertz",
            "asdfgh",
            "zxcvbn"
    })
    void isKnownPassword_expectTrue(String value) {
        // WHEN
        boolean actual = PasswordValidator.isKnownPassword(value);
        // THEN
        assertTrue(actual);
    }

    @Test
    void generateRandomPassword_expectNotNull() {
        // WHEN
        String actual = PasswordValidator.generateRandomPassword();
        // THEN
        assertNotNull(actual);
    }

}