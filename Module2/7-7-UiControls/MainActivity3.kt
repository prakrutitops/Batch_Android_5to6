package com.example.data1

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity3 : AppCompatActivity()
{
    lateinit var txt1:TextView
    lateinit var chk1:CheckBox
    lateinit var chk2:CheckBox
    lateinit var chk3:CheckBox
    lateinit var btn1:Button
    lateinit var img:ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        txt1 = findViewById(R.id.txt1)

        var i = intent
       // Toast.makeText(applicationContext,"Welcome : "+ i.getStringExtra("tops"),Toast.LENGTH_LONG).show()
        txt1.setText("Welcome: "+i.getStringExtra("tops"))

        chk1 = findViewById(R.id.chk1)
        chk2 = findViewById(R.id.chk2)
        chk3 = findViewById(R.id.chk3)
        btn1 = findViewById(R.id.btn1)
        img =  findViewById(R.id.img)

        btn1.setOnClickListener {

            var amount =0
            var builder = StringBuilder("Selected Items ")



            if(chk1.isChecked)
            {
                builder.append("\n Pizza @ Rs. 100")
                amount+=100
            }
            if(chk2.isChecked)
            {
                builder.append("\n Burger @ Rs. 70")
                amount+=70
            }
            if(chk3.isChecked)
            {
                builder.append("\n Coffee @ Rs. 120")
                amount+=120
            }

            builder.append("\n Total :"+amount)

            var i = Intent(applicationContext,MainActivity4::class.java)
            i.putExtra("Bill",builder.toString())
            startActivity(i)

        }
        img.setOnClickListener {

            var num ="9999999999"
            var i = Intent(Intent.ACTION_CALL)
            i.setData(Uri.parse("tel:"+num))
            startActivity(i)

        }
    }
}