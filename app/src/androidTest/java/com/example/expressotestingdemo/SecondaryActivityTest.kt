package com.example.expressotestingdemo

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.expressotestingdemo.ui.activities.SecondaryActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondaryActivityTest{

    //Instead of writing ActivityScenario in every method write using rule once.
    @get:Rule
    val activityRule= ActivityScenarioRule(SecondaryActivity::class.java)

    @Test
    fun checkActivityVisible(){
        Espresso.onView(ViewMatchers.withId(R.id.activitySecondaryTextViewTitle))
            .check(ViewAssertions.matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

}