package com.example.expressotestingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {
            if (edt_email.text.toString()=="ash" && edt_pass.text.toString() == "singh"){
                tv_result.text = "SUCCESS";
            }else{
                tv_result.text = "Failed";
            }
        }
    }
}
