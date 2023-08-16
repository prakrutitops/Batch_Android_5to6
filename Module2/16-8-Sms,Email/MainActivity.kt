package com.example.smsandmap

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)



        btn1.setOnClickListener {

            var num = edt1.text.toString()
            var msg = edt2.text.toString()


            var sms:SmsManager = SmsManager.getDefault()
            var i = Intent(applicationContext,MainActivity::class.java)
            var pi :PendingIntent = PendingIntent.getActivity(applicationContext,0,i,PendingIntent.FLAG_IMMUTABLE)
            sms.sendTextMessage(num,null,msg,pi,null)

        }

    }
}