package com.example.data1

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity()
{
    //Declaration of XMl Controls
    lateinit var img:ImageView
    lateinit var txt1:TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialization of Ui Controls

        img = findViewById(R.id.img)
        txt1 = findViewById(R.id.txt1)


        img.setOnClickListener {

            //explicit

                var i = Intent(applicationContext,MainActivity2::class.java)
                startActivity(i)



        }
        txt1.setOnClickListener {

            //implicit

            var url="https://www.amazon.in/HP-i3-1115G4-Micro-Edge-Anti-Glare-14s-dy2507TU/dp/B0B63Y75P9/ref=sr_1_2_sspa?crid=TW4C4XUH5Z6&keywords=laptop&qid=1688558119&sprefix=laptop%2Caps%2C458&sr=8-2-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)

        }



    }

    override fun onBackPressed()
    {
        var alert = AlertDialog.Builder(this)
        alert.setTitle("Are you sure you want to exit?")
        alert.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

            finishAffinity()
        })
        alert.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->

            dialogInterface.cancel()
        })

        alert.show()

    }



}