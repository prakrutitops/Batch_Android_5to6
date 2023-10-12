package tops.tech.retrofitcrudex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display.Mode
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewActivity : AppCompatActivity()
{
    lateinit var recyclerView: RecyclerView
    lateinit var list:MutableList<Model>
    lateinit var apiinterface:Apiinterface
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        recyclerView = findViewById(R.id.recycler)
        list = ArrayList()

        var layoutManager:RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager=layoutManager

        apiinterface=  ApiClient.getapiclient().create(Apiinterface::class.java)

        var call: Call<List<Model>> =  apiinterface.viewdata()

        call.enqueue(object: Callback<List<Model>> {
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {

                Toast.makeText(applicationContext,"a",Toast.LENGTH_LONG).show()

                list = response.body() as MutableList<Model>

                var myAdapter = MyAdapter(applicationContext,list)
                recyclerView.adapter=myAdapter
            }

            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
               Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
            }


        })



    }
}