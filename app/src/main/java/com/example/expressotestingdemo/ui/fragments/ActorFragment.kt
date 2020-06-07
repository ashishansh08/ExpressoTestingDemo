package com.example.expressotestingdemo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.expressotestingdemo.R
import kotlinx.android.synthetic.main.fragment_actor.*

class ActorFragment  : Fragment(){
    companion object{
        fun getInstance(actors: ArrayList<String>):ActorFragment{
            val actorFragment=ActorFragment()
            val bundle = Bundle()
            bundle.putStringArrayList("args_actors", actors)
            actorFragment.arguments = bundle
            return ActorFragment()
        }
    }

    private val starActors: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            starActors.addAll(args.get("args_actors") as List<String>)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_actor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setActors()
    }

    private fun setActors(){
        star_actors_text.text = starActors.stringBuilderForStarActors()
    }

}

fun ArrayList<String>.stringBuilderForStarActors(): String{
    val sb = StringBuilder()
    for(actor in this){
        sb.append(actor + "\n")
    }
    return sb.toString()
}














