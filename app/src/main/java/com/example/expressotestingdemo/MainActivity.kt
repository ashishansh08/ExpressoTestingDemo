package com.example.expressotestingdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainButtonSubmit.setOnClickListener {
            if (mainEditTextEmail.text.toString()=="ash" && mainEditTextPassword.text.toString() == "singh"){
                mainTextViewResult.text = "SUCCESS";
                startNewActivity()
            }else{
                mainTextViewResult.text = "Failed";
            }
        }
    }

    private fun startNewActivity() {
        val intent = Intent(this, SecondaryActivity::class.java)
        startActivity(intent)
    }
}
