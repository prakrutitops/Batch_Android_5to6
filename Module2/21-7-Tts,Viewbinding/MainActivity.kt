package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.QUEUE_ADD
import android.view.Display.Mode
import android.widget.Adapter
import android.widget.ListView
import android.widget.TextView
import com.example.myapplication.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var binding: ActivityMainBinding
    lateinit var tts:TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



       binding.t1.setText("Android")

       tts= TextToSpeech(applicationContext,this)


        binding.btn1.setOnClickListener {

            var data = binding.edt1.text.toString()
            var data2 = binding.t1.text.toString()
            tts.speak(data,QUEUE_ADD,null,null)

        }

    }

    override fun onInit(status: Int)
    {
        tts.setLanguage(Locale.UK)
        tts.setPitch(0.5F)
        tts.setSpeechRate(0.8F)

    }
}