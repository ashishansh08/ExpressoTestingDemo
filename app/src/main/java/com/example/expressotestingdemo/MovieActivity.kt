package com.example.expressotestingdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //supportFragmentManager.fragmentFactory = MovieFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        init()
    }

    private fun init() {
        val movieId = 1
        val bundle = Bundle()
        bundle.putInt("movie_id", movieId)

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerMovieLayout, MovieDetailFragment.newInstance(movieId = 1))
            .commit()
    }

}