package com.example.prefrencescreen

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var txt1:TextView
    lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        txt1 = findViewById(R.id.txt1)

        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(applicationContext)

        btn1.setOnClickListener {

            var i = Intent(applicationContext,MainActivity2::class.java)
            startActivity(i)

        }
        btn2.setOnClickListener {

           // var editor:SharedPreferences.Editor = sharedPreferences.edit()


            var name:String = sharedPreferences.getString("name","Please Enter Name")!!
            var pass:String = sharedPreferences.getString("pass","Please Enter Password")!!
            var ans:Boolean =  sharedPreferences.getBoolean("check1",false)
            var list:String = sharedPreferences.getString("list1","Please Enter List Detail")!!

            txt1.append(name)
            txt1.append(pass)
            txt1.append(ans.toString())
            txt1.append(list)




        }


    }
}