package tops.tech.firebasecrudapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasecrudapp.Model
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase

class ViewActivity : AppCompatActivity()
{
    lateinit var recyclerView: RecyclerView
    lateinit var adapter:MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        recyclerView = findViewById(R.id.recycler)

        var manager:RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager=manager

        var options = FirebaseRecyclerOptions.Builder<Model>()
            .setQuery(FirebaseDatabase.getInstance().reference.child("android"), Model::class.java)
            .build()

         adapter = MyAdapter(options)
        recyclerView.adapter=adapter


    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()

    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }

    override fun onResume() {
        super.onResume()
        adapter.startListening()
    }

    override fun onRestart() {
        super.onRestart()
        adapter.startListening()
    }

    override fun onPause() {
        super.onPause()
        adapter.stopListening()
    }

}