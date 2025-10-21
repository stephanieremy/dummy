package com.dummy.project.adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidationTest {

    @Test
    public void testUsingSimpleRegex() {
        var emailAddress = "username@domain.com";
        var regexPattern = "^(.+)@(\\S+)$";
        assertTrue(emailAddress.matches(regexPattern));
    }
}
