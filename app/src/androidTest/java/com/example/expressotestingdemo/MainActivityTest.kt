package com.example.expressotestingdemo

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers.containsString
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest{
    private lateinit var stringToBetyped: String

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    @Before
    fun initValidString() {
        // Specify a valid string.
        stringToBetyped = "SUCCESS"
    }

    @Test
    fun changeText_sameActivity() {
        onView(withId(R.id.edt_email)).perform(typeText("ash"), closeSoftKeyboard());

        onView(withId(R.id.edt_pass)).perform(typeText("singh"), closeSoftKeyboard());

        onView(withId(R.id.btn_login)).perform(click());

       // onView(withId(R.id.tv_result)).check(matches(withText("SUCCESS")));


        /*perform(typeText(stringToBetyped), Espresso.closeSoftKeyboard())
        onView(withId(R.id.btn_login)).perform(click())
        onView(withId(R.id.tv_result)).check(matches(withText("SUCCESS")));*/
    }
}

private fun ViewInteraction.perform(typeText: ViewAction?, closeSoftKeyboard: Unit) {

}


