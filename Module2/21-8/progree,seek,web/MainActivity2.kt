package com.example.dateandtimepickerex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.ProgressBar

class MainActivity2 : AppCompatActivity()
{
    lateinit var pb:ProgressBar
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var webview:WebView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        pb = findViewById(R.id.pb)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        webview = findViewById(R.id.web)

        webview.loadUrl("https://www.google.com")

        btn1.setOnClickListener {

            pb.incrementProgressBy(1)
            setProgress(100*pb.progress)

        }
        btn2.setOnClickListener {

            pb.incrementProgressBy(-1)
            setProgress(100*pb.progress)


        }
    }
}