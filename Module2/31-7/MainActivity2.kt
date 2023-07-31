package com.example.detail1

import android.Manifest.permission.CAMERA
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import com.example.detail1.databinding.ActivityMain2Binding
import com.example.detail1.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity()
{
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if(checkSelfPermission(CAMERA)!=PERMISSION_GRANTED)
        {
            requestPermissions(arrayOf(CAMERA),101)
        }

        binding.img.setOnClickListener {

            var i = Intent(ACTION_IMAGE_CAPTURE)
            startActivityForResult(i,1)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode==1 && resultCode== RESULT_OK)
        {

            var bm:Bitmap = data!!.extras!!.get("data") as Bitmap
            binding.img2.setImageBitmap(bm)

        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}