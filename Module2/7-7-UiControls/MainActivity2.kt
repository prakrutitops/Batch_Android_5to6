package com.example.data1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        edt1 = findViewById(R.id.edtname)
        edt2=findViewById(R.id.edtpass)
        btn1 = findViewById(R.id.btn1)


        btn1.setOnClickListener {

            var name = edt1.text.toString()
            var pass = edt2.text.toString()

            if (name.length == 0 && pass.length == 0)
            {
                edt1.setError("Please Enter Name")
                edt2.setError("Please Enter Password")
            }
            else if (name.length == 0)
            {
                edt1.setError("Please Enter Name")
            }

            else if (pass.length == 0)
            {
                edt2.setError("Please Enter Password")
            }

            else
            {
                if(name.equals("sahil") && pass.equals("1234"))
                {
                    Toast.makeText(applicationContext,"Logged in Succesfully",Toast.LENGTH_LONG).show()
                    //startActivity(Intent(applicationContext,MainActivity3::class.java))
                    var i = Intent(applicationContext,MainActivity3::class.java)
                    i.putExtra("tops",name)
                    startActivity(i)
                }


                else
                {
                    Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
                }

            }


        }

    }
}