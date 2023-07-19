package com.example.data3

import android.annotation.SuppressLint
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.daimajia.slider.library.Transformers.AccordionTransformer

class MainActivity : AppCompatActivity()
{
    lateinit var sliderlayout: SliderLayout
    lateinit var map :HashMap<String,Int>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sliderlayout = findViewById(R.id.slider)
        map = HashMap<String,Int>()

        map.put("A",R.drawable.a)
        map.put("B",R.drawable.abc)
        map.put("C",R.drawable.a)
        map.put("D",R.drawable.abc)

        for(i in map.keys)
        {

            var txtslider = TextSliderView(this)

            txtslider.description(i)
            txtslider.image(map.get(i)!!)

            sliderlayout.addSlider(txtslider)
            sliderlayout.setPresetTransformer(SliderLayout.Transformer.FlipPage)
        }

    }
}