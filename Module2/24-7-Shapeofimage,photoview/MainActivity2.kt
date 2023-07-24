package com.example.customlistex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.github.chrisbanes.photoview.PhotoView

class MainActivity2 : AppCompatActivity()
{
    lateinit var imageView: PhotoView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        imageView = findViewById(R.id.p1)

        var i = intent
        var pos2 = i.getStringExtra("pos")

        Toast.makeText(applicationContext,""+pos2,Toast.LENGTH_LONG).show()
        var pos3 = i.getIntExtra("img2",101)
        imageView.setImageResource(pos3)
        //textview.settext(pos2)
    }
}