package com.example.expressotestingdemo.ui.activities

import MovieFragmentFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.expressotestingdemo.ui.fragments.MovieDetailFragment
import com.example.expressotestingdemo.R

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = MovieFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        init()
    }

    private fun init() {
        if(supportFragmentManager.fragments.size == 0){
            val movieId = 1
            val bundle = Bundle()
            bundle.putInt("movie_id", movieId)
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerMovieLayout, MovieDetailFragment::class.java, bundle)
                .commit()
        }
    }
}