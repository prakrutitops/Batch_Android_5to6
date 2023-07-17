package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.ListView

class MainActivity : AppCompatActivity()
{
    lateinit var listView: GridView
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()


        list.add(Model(R.drawable.b,"B","Hello"))
        list.add(Model(R.drawable.b,"B","Hello"))
        list.add(Model(R.drawable.b,"B","Hello"))
        list.add(Model(R.drawable.b,"B","Hello"))


        var adapter = MyAdapter(applicationContext,list)
        listView.adapter=adapter

    }
}