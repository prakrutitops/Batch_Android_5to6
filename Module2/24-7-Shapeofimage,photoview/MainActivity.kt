package com.example.shapeofimage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shapeofimage.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

       var a1 =  binding.c1.setImageResource(R.drawable.a1)
        binding.c2.setImageResource(R.drawable.b1)
        binding.c3.setImageResource(R.drawable.c1)
        binding.c4.setImageResource(R.drawable.d1)

        binding.c1.setOnClickListener {

            var i = Intent(applicationContext,MainActivity2::class.java)
            i.putExtra("img",a1.toString())
            startActivity(i)

        }
        binding.c2.setOnClickListener {

        }
        binding.c3.setOnClickListener {

        }
        binding.c4.setOnClickListener {

        }
    }
}