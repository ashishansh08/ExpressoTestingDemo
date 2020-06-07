package com.example.expressotestingdemo.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.expressotestingdemo.ui.fragments.MovieDetailFragment
import com.example.expressotestingdemo.R

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //supportFragmentManager.fragmentFactory = MovieFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        init()
    }

    private fun init() {
        val movieId = 1
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.containerMovieLayout,
                MovieDetailFragment.newInstance(
                    movieId = 1
                )
            )
            .commit()
    }

}