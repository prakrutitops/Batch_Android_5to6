package com.example.detail1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.detail1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var layoutmanager:RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager=layoutmanager

        list = ArrayList()

        list.add(Model(R.drawable.a,"person 1"))
        list.add(Model(R.drawable.b,"person 2"))
        list.add(Model(R.drawable.c,"person 3"))
        list.add(Model(R.drawable.d,"person 4"))


        var myadapter =  MyAdapter(applicationContext,list)
        binding.recycler.adapter=myadapter


    }
}