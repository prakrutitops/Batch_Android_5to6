package com.example.customlistex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list: MutableList<Model>


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()

        //set
        list.add(Model(R.drawable.a,"A","Hii","7-8-20"))
        list.add(Model(R.drawable.b,"B","Hello","7-8-21"))
        list.add(Model(R.drawable.c,"C","Hii","7-8-22"))
        list.add(Model(R.drawable.d,"D","Hello","7-8-23"))

        var adapter = MyAdapter(applicationContext,list)
        listView.adapter=adapter

        listView.setOnItemClickListener { parent, view, position, id ->


            Toast.makeText(applicationContext,""+position,Toast.LENGTH_LONG).show()

            var i= Intent(applicationContext,MainActivity2::class.java)
            i.putExtra("pos",list.get(position).date)
            i.putExtra("img2",list.get(position).image)
            startActivity(i)


        }


    }
}