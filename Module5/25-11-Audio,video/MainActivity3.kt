package tops.tech.audiovideoex


import android.media.MediaPlayer
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.appcompat.app.AppCompatActivity


class MainActivity3 : AppCompatActivity(), SurfaceHolder.Callback {
    var url = "https://topsapi.000webhostapp.com/API/movie.mp4"
    private var mediaPlayer: MediaPlayer? = null
    private var surfaceView: SurfaceView? = null
    private var holder: SurfaceHolder? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        surfaceView = findViewById<SurfaceView>(R.id.surfaceView)
        mediaPlayer = MediaPlayer()
        holder = surfaceView!!.getHolder()
        holder!!.setFixedSize(800, 480)
        holder!!.addCallback(this)
        holder!!.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)

    }

    override fun surfaceCreated(p0: SurfaceHolder) {
        mediaPlayer!!.setDisplay(holder);
        play()
    }

    private fun play()
    {
        mediaPlayer!!.setDataSource(url)
        mediaPlayer!!.prepare()
        mediaPlayer!!.start()
    }

    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {

    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {

    }
}