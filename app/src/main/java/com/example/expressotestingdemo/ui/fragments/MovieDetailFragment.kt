package com.example.expressotestingdemo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.codingwithmitch.espressouitestexamples.data.source.MoviesRemoteDataSource
import com.example.expressotestingdemo.R
import com.example.expressotestingdemo.model.Movie
import kotlinx.android.synthetic.main.fragment_movie_detail.*

class MovieDetailFragment: Fragment() {

    private lateinit var movie: Movie

    companion object {
        fun newInstance(movieId: Int): MovieDetailFragment {
            val fragment = MovieDetailFragment()
            val args = Bundle()
            args.putInt("movie_id", movieId)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            args.getInt("movie_id").let { movieId ->
                MoviesRemoteDataSource.getMovie(movieId)?.let { movieFromRemote ->
                    movie = movieFromRemote
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setMovieDetails()

        movie_directiors.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.containerMovieLayout, DirectorFragment.getInstance(movie.directors), null)
                ?.addToBackStack("DirectorsFragment")
                ?.commit()
        }

        movie_star_actors.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.containerMovieLayout, ActorFragment.getInstance(movie.star_actors!!))
                ?.addToBackStack("StarActorsFragment")
                ?.commit()
        }
    }

    private fun setMovieDetails(){
        movie.let{ nonNullMovie ->
            movie_title.text = nonNullMovie.title
            movie_description.text = nonNullMovie.description
        }
    }
}