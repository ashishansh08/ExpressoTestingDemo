package com.example.expressotestingdemo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.expressotestingdemo.R
import kotlinx.android.synthetic.main.fragment_director.*

class DirectorFragment : Fragment(){

    companion object{
        fun getInstance(directors: ArrayList<String>?):DirectorFragment{

            val directorFragment=DirectorFragment()
            val bundle = Bundle()
            bundle.putStringArrayList("args_directors", directors)
            directorFragment.arguments = bundle
            return DirectorFragment()
        }
    }

    private val directors: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            directors.addAll(args.get("args_directors") as List<String>)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_director, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDirectors()
    }

    private fun setDirectors(){
        directors_text.text = directors.stringBuilderForDirectors()
    }
}

fun ArrayList<String>.stringBuilderForDirectors(): String{
    val sb = StringBuilder()
    for(director in this){
        sb.append(director + "\n")
    }
    return sb.toString()
}

















