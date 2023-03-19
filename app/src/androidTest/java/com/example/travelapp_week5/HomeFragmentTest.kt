package com.example.travelapp_week5

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import junit.framework.TestCase
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    @Before
    fun setup() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.onActivity { activity ->
            val fragment = HomeFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }
    }

    @Test
    fun test_SignUpButton() {
        onView(withId(R.id.signUpButton)).perform(click())

        //Check if the sign-up fragment is displayed
        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()))

    }

    @Test
    fun test_SignInButton() {
        onView(withId(R.id.signInButton)).perform(click())

        //Check if sign_in fragment is displayed
        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()))
    }
}
