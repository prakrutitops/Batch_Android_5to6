package com.example.sqlitedb

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class UpdateActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button
    lateinit var dbHelper: DbHelper

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)
        dbHelper = DbHelper(applicationContext)

        var i = intent
        var id = i.getIntExtra("ID",0)
        edt1.setText(i.getStringExtra("NAME"))
        edt2.setText(i.getStringExtra("NUM"))

        btn1.setOnClickListener {

            var name11 = edt1.text.toString()
            var num11 = edt2.text.toString()

            var m = Model()
            m.id=id
            m.name=name11//set
            m.num=num11//set

            dbHelper.updatedata(m)

            startActivity(Intent(applicationContext,MainActivity2::class.java))

        }

    }
}