package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity()
{

    //declaration

    lateinit var b1:Button
    lateinit var text:TextView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b1 = findViewById(R.id.btn1)
        text=findViewById(R.id.t1)
        b1.setOnClickListener {
           // Toast.makeText(applicationContext, "Success", Toast.LENGTH_SHORT).show()
        }
        text.setOnClickListener {
            Toast.makeText(applicationContext, "hello", Toast.LENGTH_SHORT).show()
        }





    }
}