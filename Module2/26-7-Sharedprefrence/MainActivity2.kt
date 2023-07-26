package com.example.sharedprefrenceex

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.sharedprefrenceex.databinding.ActivityMain2Binding
import com.example.sharedprefrenceex.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity()
{
    lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)
        Toast.makeText(applicationContext,"Welcome :"+sharedPreferences.getString("email","default value"),Toast.LENGTH_LONG).show()

        binding.btn1.setOnClickListener {

            sharedPreferences.edit().clear().commit()
            startActivity(Intent(applicationContext,MainActivity::class.java))
            finish()
        }


    }


}