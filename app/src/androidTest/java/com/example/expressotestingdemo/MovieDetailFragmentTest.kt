package com.example.expressotestingdemo

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.expressotestingdemo.ui.fragments.MovieDetailFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class MovieDetailFragmentTest {

    @Test
    fun isMovieDataAvaialble(){
        //SETUP
        val muvie = DummyMovies.THE_RUNDOWN

        val bundle= Bundle()

    }

}