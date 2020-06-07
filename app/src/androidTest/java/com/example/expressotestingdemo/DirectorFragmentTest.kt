package com.example.expressotestingdemo

import MovieFragmentFactory
import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.expressotestingdemo.ui.fragments.ActorFragment
import com.example.expressotestingdemo.ui.fragments.DirectorFragment
import com.example.expressotestingdemo.ui.fragments.stringBuilderForDirectors
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class DirectorFragmentTest {

    @Test
    fun checkIfDirectorListSet(){
        //Setup
        val directors = arrayListOf("R.J. Stewart", "James Vanderbilt")

        val bundle=Bundle()
        val fragmentFactory=MovieFragmentFactory()
        bundle.putStringArrayList("args_directors", directors)

        val scenario = launchFragmentInContainer<DirectorFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        //Verify
        onView(withId(R.id.directors_text)).check(matches(withText(directors.stringBuilderForDirectors())))
    }
}