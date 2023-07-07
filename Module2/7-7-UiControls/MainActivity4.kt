package com.example.data1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity4 : AppCompatActivity()
{
    lateinit var txt1: TextView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        txt1 = findViewById(R.id.txt1)

        var i = intent
        // Toast.makeText(applicationContext,"Welcome : "+ i.getStringExtra("tops"),Toast.LENGTH_LONG).show()
        txt1.setText(i.getStringExtra("Bill"))
    }
}