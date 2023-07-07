package com.example.data1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed(Runnable {

            /*   var i = Intent(applicationContext,MainActivity2::class.java)
                startActivity(i)
                */

                startActivity(Intent(applicationContext,MainActivity2::class.java))

        },3000)

    }
}