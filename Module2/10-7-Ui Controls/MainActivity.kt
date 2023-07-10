package com.example.listex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var rb1:RadioButton
    lateinit var rb2:RadioButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rb1 = findViewById(R.id.rb1)
        rb2 = findViewById(R.id.rb2)

        rb1.setOnCheckedChangeListener { buttonView, isChecked ->

            if(rb1.isChecked)
            {
                Toast.makeText(applicationContext,"Male",Toast.LENGTH_LONG).show()
            }

        }
        rb2.setOnCheckedChangeListener { buttonView, isChecked ->

            if(rb2.isChecked)
            {
                Toast.makeText(applicationContext,"Female",Toast.LENGTH_LONG).show()
            }

        }


    }
}