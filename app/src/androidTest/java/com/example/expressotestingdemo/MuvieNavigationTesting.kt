package com.example.expressotestingdemo

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.expressotestingdemo.ui.activities.SecondaryActivity
import kotlinx.android.synthetic.main.activity_secondary.*
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class MuvieNavigationTesting {

    @Test
    fun testMuvieNavigation(){
        //Setup
        val activityScenario= ActivityScenario.launch(SecondaryActivity::class.java)

        onView(withId(R.id.secondaryMainLayout)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

        onView(withId(R.id.actvitySecondaryButtonStartFragment)).perform(click())

        onView(withId(R.id.movieDetailsMain)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

        onView(withId(R.id.movie_directiors)).perform(click())

        onView(withId(R.id.muvieActorMain)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

        pressBack()

        onView(withId(R.id.movie_star_actors)).perform(click())

        onView(withId(R.id.actorMain)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

    }
}