package com.example.test123

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var linearLayout: LinearLayout
    lateinit var txt1:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.relative)

        linearLayout = LinearLayout(this)
        txt1 = TextView(this)

        txt1.setText("Hello")
        var width=100
        var height=100


        linearLayout.addView(txt1,width,height)
        setContentView(linearLayout)
    }
}