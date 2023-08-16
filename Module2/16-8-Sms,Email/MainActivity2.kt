package com.example.smsandmap

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity()
{
    lateinit var To: EditText
    lateinit var Sub:EditText
    lateinit var Message:EditText
    lateinit var send: Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        To=findViewById(R.id.edt1)
        Sub=findViewById(R.id.edt2)
        Message=findViewById(R.id.edt3)
        send=findViewById(R.id.btn1)

        send.setOnClickListener {


            val to = To.text.toString()
            val sub = Sub.text.toString()
            val message = Message.text.toString()

            val email = Intent(Intent.ACTION_SEND)
            email.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
            email.putExtra(Intent.EXTRA_SUBJECT,sub)
            email.putExtra(Intent.EXTRA_TEXT,message)
            email.setType("messsage/rfc822")
            startActivity(email)

        }

    }
}