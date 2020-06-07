package com.example.expressotestingdemo

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.expressotestingdemo.ui.activities.MainActivity
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class MainActivityTest {
    @Test
    fun testActivity_inView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        //check if activity top view is visible or not, TWO WAYS :
        onView(withId(R.id.mainLayout)).check(matches(isDisplayed())) //Method 1

        onView(withId(R.id.mainButtonSubmit)).check(matches(withEffectiveVisibility(Visibility.VISIBLE))) //Method 2 for visibility check

    }

    @Test
    fun navigateToSecondaryActivity(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        //Enter username and pw
        onView(withId(R.id.mainEditTextEmail)).perform(typeText("ash"))
        onView(withId(R.id.mainEditTextPassword)).perform(typeText("singh"))

        //close this keyboard before performing click else case will give error
        closeSoftKeyboard()

        //perform click
        onView(withId(R.id.mainButtonSubmit)).perform(click())

        onView(withId(R.id.secondaryMainLayout)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

        //FOR NAVIGATING BACK, TWO WAYS :
        // onView(withId(R.id.mainButtonSubmit)).perform(click()) //WAY ONE
        pressBack() //WAY TWO

        //Check if first fragment view is visible or not
        onView(withId(R.id.mainLayout)).check(matches(isDisplayed()))
    }
}