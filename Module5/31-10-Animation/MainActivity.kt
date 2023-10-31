package tops.tech.myapplication

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity()
{
    lateinit var imageView: ImageView
    lateinit var animationDrawable: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.img)
        animationDrawable= imageView.getBackground() as AnimationDrawable

        animationDrawable.start()


    }
}