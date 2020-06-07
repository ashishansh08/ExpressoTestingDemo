package com.example.expressotestingdemo.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.expressotestingdemo.R
import kotlinx.android.synthetic.main.activity_secondary.*

class SecondaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        actvitySecondaryButtonBack.setOnClickListener {
            onBackPressed()
        }

        actvitySecondaryButtonStartFragment.setOnClickListener {
            startMuvieActivity()
        }
    }

    private fun startMuvieActivity() {
        val intent = Intent(this, MovieActivity::class.java)
        startActivity(intent)
    }
}
