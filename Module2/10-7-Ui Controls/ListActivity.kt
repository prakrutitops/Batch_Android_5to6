package com.example.listex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView

class ListActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list:MutableList<String>
    lateinit var searchView: SearchView

    override @SuppressLint("MissingInflatedId")
fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        listView = findViewById(R.id.list)
        list = ArrayList()
        searchView = findViewById(R.id.search)

        //add data in list
        list.add("Android")
        list.add("Java")
        list.add("Php")
        list.add("Kotlin")

        //ArrAyAdapter - data will set from list to android resourc file
        var adapter1 = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,list)
        listView.adapter=adapter1

        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

             /*   if(list.contains(query))
                {
                    adapter1.filter.filter(query)
                }*/

                return false

            }

            override fun onQueryTextChange(newText: String?): Boolean
            {
                adapter1.filter.filter(newText)

                return false
            }
        })


    }


}