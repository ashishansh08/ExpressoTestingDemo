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
import com.example.expressotestingdemo.ui.fragments.MovieDetailFragment
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class MovieDetailFragmentTest {

    @Test
    fun isMovieDataAvaialble(){
        //SETUP
        val muvie = DummyMovies.THE_RUNDOWN
        val fragmentFactory= MovieFragmentFactory()
        val bundle= Bundle()
        bundle.putInt("movie_id", muvie.id)

        val scenario = launchFragmentInContainer<MovieDetailFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        onView(withId(R.id.movie_title)).check(matches(withText(muvie.title)))



    }

}