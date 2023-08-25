package com.example.sqlitedb

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button
    lateinit var dbHelper: DbHelper

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)
        dbHelper = DbHelper(applicationContext)

        btn1.setOnClickListener {

            var name11 = edt1.text.toString()
            var num11 = edt2.text.toString()

            var m = Model()
            m.name=name11//set
            m.num=num11//set

            var id = dbHelper.insertdata(m)

          Toast.makeText(applicationContext,"Record Inserted "+id,Toast.LENGTH_LONG).show()

        }


    }
}