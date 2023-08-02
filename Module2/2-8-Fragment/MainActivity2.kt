package com.example.fragmentex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.fragmentex.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity()
{

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn1.setOnClickListener {
            // A to A
        }
        binding.btn2.setOnClickListener {

            //A to F

            var b1 = BlankFragment()
            var fm:FragmentManager = supportFragmentManager
            var ft:FragmentTransaction = fm.beginTransaction()
            ft.replace(R.id.frmid,b1).commit()


        }
        binding.btn3.setOnClickListener {

        }
        binding.btn4.setOnClickListener {

        }
    }
}