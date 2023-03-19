package com.example.travelapp_week5

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SignUpFragmentTest {

    //Testing Validation Code in the Sign Up Fragment

    // Email Validation Tests
    @Test
    fun test_validateEmail_InvalidEmailAddress() {
        //Given
        val fragment = SignUpFragment()
        //When
        val result = fragment.validateEmail("user@domain")
        //Then
        assertEquals("Invalid email address", result)
    }

    @Test
    fun test_validateEmail_EmptyEmailAddress() {
        //Given
        val fragment = SignUpFragment()
        //When
        val result = fragment.validateEmail("")
        assertEquals("Email is required", result)
    }

    // Phone Validation Tests
    @Test
    fun test_validatePhone_withEmptyPhoneNumber() {
        //Given
        val fragment = SignUpFragment()
        //when
        val result = fragment.validatePhone("")
        //Then
        assertEquals("Phone number is required", result)
    }

    @Test
    fun test_validatePhoneWithPhoneNumberLessThan_10_digits() {
        //Given
        val fragment = SignUpFragment()
        //when
        val result = fragment.validatePhone("123456789")
        assertEquals("Phone number must be 10 digits", result)
    }

    @Test
    fun test_validatePhoneWithPhoneNumberMoreThan_10_digits() {
        //Given
        val fragment = SignUpFragment()
        //when
        val result = fragment.validatePhone("12345678901")
        assertEquals("Phone number must be 10 digits", result)
    }

    @Test
    fun test_validatePhone_validPhoneNumber() {
        //Given
        val fragment = SignUpFragment()
        //when
        val result = fragment.validatePhone("1234567890")
        assertEquals(null, result)
    }

    // Name Validation Tests
    @Test
    fun test_validateNameWithEmptyName() {
        //Given
        val fragment = SignUpFragment()
        //when
        val result = fragment.validateName("")
        assertEquals("User name is required", result)
    }

    @Test
    fun test_validateNameWithInvalidNameFormat() {
        //Given
        val fragment = SignUpFragment()
        //when
        val result = fragment.validateName("Jon")
        assertEquals("Please enter both first and last names separated by a space", result)
    }

    @Test
    fun `test validateName with non-alphabetic characters in name`() {
        //Given
        val fragment = SignUpFragment()
        //when
        val result = fragment.validateName("John123 Smith456")
        assertEquals("First and last names must contain only alphabets", result)
    }

    @Test
    fun test_validateName_WithValidName() {
        //Given
        val fragment = SignUpFragment()
        //when
        val result = fragment.validateName("Jon Wick")
        assertEquals(null, result)
    }

    // Gender Validation Tests
    @Test
    fun test_validateGender_withInvalidGender() {
        //Given
        val fragment = SignUpFragment()
        //when
        val result = fragment.validateGender("Other")
        assertEquals(null, result)
    }

    @Test
    fun test_validateGender_withBlankGender() {
        //Given
        val fragment = SignUpFragment()
        //when
        val result = fragment.validateGender("")
        assertEquals("Please select a valid gender", result)
    }

}
