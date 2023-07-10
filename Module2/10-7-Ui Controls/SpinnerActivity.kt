package com.example.listex

import android.Manifest.permission.CALL_PHONE
import android.annotation.SuppressLint
import android.content.pm.PackageManager.PERMISSION_GRANTED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.RatingBar
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.snackbar.Snackbar

class SpinnerActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var spin:Spinner
    lateinit var ratingBar: RatingBar
    var city = arrayOf("Rajkot","Baroda","Surat","Surendranagar")
    lateinit var auto:AutoCompleteTextView
    lateinit var btn1:AppCompatButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)


        spin = findViewById(R.id.spin)
        ratingBar = findViewById(R.id.rating)
        auto = findViewById(R.id.a1)

        if(checkSelfPermission(CALL_PHONE)!=PERMISSION_GRANTED)
        {
            requestPermissions(arrayOf(CALL_PHONE),101)
        }




        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item,city)
        spin.adapter=adapter


        var adapter2 = ArrayAdapter(applicationContext,android.R.layout.select_dialog_item,city)
        auto.threshold=1
        auto.setAdapter(adapter2)

        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {

                Snackbar.make(it,"Success",Snackbar.LENGTH_LONG).show()

        }



        spin.setOnItemSelectedListener(this)
        ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->

            Toast.makeText(applicationContext,""+ratingBar.rating,Toast.LENGTH_LONG).show()

        }

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            Toast.makeText(applicationContext,""+city[position],Toast.LENGTH_LONG).show()

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

        Toast.makeText(applicationContext,"",Toast.LENGTH_LONG).show()
    }
}