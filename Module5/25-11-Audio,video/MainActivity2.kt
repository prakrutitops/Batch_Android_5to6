package tops.tech.audiovideoex

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity()
{
    lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        videoView = findViewById(R.id.videoView)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        val video: Uri = Uri.parse("https://topsapi.000webhostapp.com/API/movie.mp4")
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(video)
        videoView.start()

    }
}