package tops.tech.audiovideoex

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException

class MainActivity : AppCompatActivity(), MediaPlayer.OnPreparedListener {
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var mediaPlayer: MediaPlayer
    var url="https://topsapi.000webhostapp.com/API/ram_siya_ram.mp3"
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)

        //mediaPlayer = MediaPlayer.create(applicationContext,R.raw.ram_siya_ram)
        //mediaPlayer = MediaPlayer.create(applicationContext)
        mediaPlayer = MediaPlayer()




        btn1.setOnClickListener {

               // mediaPlayer.start()
            try {
                mediaPlayer.setDataSource(url)
                mediaPlayer.prepareAsync()
                mediaPlayer.setOnPreparedListener(this)
                //imageButton.setImageResource(android.R.drawable.ic_media_pause)
            } catch (e: IOException) {
                e.printStackTrace()
            }

           /* if (mediaPlayer.isPlaying) {
                //imageButton.setImageResource(android.R.drawable.ic_media_play)
                mediaPlayer.pause()
            } else {
                mediaPlayer.start()
                //imageButton.setImageResource(android.R.drawable.ic_media_pause)
            }*/

        }
        btn2.setOnClickListener {

                mediaPlayer.stop()
        }

    }
    fun playSong(view: View?)
    {

    }

    override fun onPrepared(p0: MediaPlayer?)
    {
        mediaPlayer.start()
    }

}