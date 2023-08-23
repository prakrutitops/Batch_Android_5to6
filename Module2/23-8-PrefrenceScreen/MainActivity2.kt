package com.example.prefrencescreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceActivity

class MainActivity2 : PreferenceActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.prefs)
        //setContentView(R.layout.activity_main2)
    }
}