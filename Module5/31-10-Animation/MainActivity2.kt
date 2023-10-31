package tops.tech.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout

class MainActivity2 : AppCompatActivity()
{
   // lateinit var linearlayout:LinearLayout
    lateinit var imageView: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        imageView = findViewById(R.id.img)

        anim()

    }

    private fun anim()
    {
        var utils = AnimationUtils.loadAnimation(applicationContext,R.anim.blink)
        imageView.startAnimation(utils)
    }
}