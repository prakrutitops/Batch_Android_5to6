package com.example.tablayoutex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.example.tablayoutex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.tool)

        binding.tab.setupWithViewPager(binding.viewpager)

        setupdata()



    }

    private fun setupdata()
    {
            var myAdapter = MyAdapter(supportFragmentManager)
            myAdapter.adddata(ChatFragment(),"CHAT")
            myAdapter.adddata(CallFragment(),"CALL")
            myAdapter.adddata(StatusFragment(),"STATUS")
            binding.viewpager.adapter=myAdapter

    }

}