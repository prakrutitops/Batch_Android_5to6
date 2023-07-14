package com.example.test123

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity2 : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var ratingBar: RatingBar


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext,"Created",Toast.LENGTH_LONG).show()
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        ratingBar = findViewById(R.id.rating)

        ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->

            var l1 = LayoutInflater.from(applicationContext)
            var view =  l1.inflate(R.layout.toast_design2,null)
            var toast = Toast(applicationContext)
            toast.view=view
            var t1:TextView = view.findViewById(R.id.txt1)
            t1.setText(ratingBar.rating.toString())
            toast.duration=Toast.LENGTH_LONG
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()


        }

        btn1.setOnClickListener {

            var l1 = LayoutInflater.from(applicationContext)
            var view =  l1.inflate(R.layout.toast_design,null)
            var t1 = Toast(applicationContext)
            t1.view=view
            t1.duration=Toast.LENGTH_LONG
            t1.setGravity(Gravity.CENTER,0,0)
            t1.show()


        }
        btn2.setOnClickListener {


            var l1 = LayoutInflater.from(applicationContext)
            var view =  l1.inflate(R.layout.toast_design,null)
            //var t1 = Toast(applicationContext)
            var t1 = AlertDialog.Builder(this)
            t1.setView(view)
            t1.show()

        }

    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext,"Started",Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext,"Stopped",Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext,"Destroy",Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext,"resume",Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext,"Pause",Toast.LENGTH_LONG).show()

    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(applicationContext,"Restart",Toast.LENGTH_LONG).show()
    }
}