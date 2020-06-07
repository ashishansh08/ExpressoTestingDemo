package com.example.expressotestingdemo.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.codingwithmitch.espressouitestexamples.data.source.MoviesRemoteDataSource
import com.example.expressotestingdemo.R
import com.example.expressotestingdemo.model.Movie
import kotlinx.android.synthetic.main.fragment_movie_detail.*

const val GALLARY_REQUEST_CODE = 12345
class MovieDetailFragment: Fragment() {

    private lateinit var movie: Movie

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
            val bundle = Bundle()
            bundle.putStringArrayList("args_directors", movie.directors)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.containerMovieLayout, DirectorFragment::class.java, bundle)
                ?.addToBackStack("DirectorsFragment")
                ?.commit()
        }

        movie_star_actors.setOnClickListener {
            val bundle = Bundle()
            bundle.putStringArrayList("args_actors", movie.star_actors)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.containerMovieLayout, ActorFragment::class.java, bundle)
                ?.addToBackStack("StarActorsFragment")
                ?.commit()
        }

        movieImageView.setOnClickListener{
            pickImageFromGallery()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode== GALLARY_REQUEST_CODE){
            data?.data?.let {
                Glide.with(this).load(it).into(movieImageView)
            }
        }
    }

    private fun pickImageFromGallery() {
        val intent=Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, GALLARY_REQUEST_CODE)
    }

    private fun setMovieDetails(){
        movie.let{ nonNullMovie ->
            movie_title.text = nonNullMovie.title
            movie_description.text = nonNullMovie.description
        }
    }
}