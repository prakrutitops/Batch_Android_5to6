package tops.tech.jsonparsingex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class MainActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()

        //StringRequest
        var stringRequest = StringRequest(Request.Method.GET,"https://vyasprakruti.000webhostapp.com/GiftShop/books_view.php",
            {
                    response->
                try
                {
                    var jsonArray = JSONArray(response)
                    for(i in 0 until jsonArray.length())
                    {
                        var jsonObject = jsonArray.getJSONObject(i)

                        var gift_name = jsonObject.getString("gift_name")
                        var gift_price = jsonObject.getString("gift_price")
                        var image = jsonObject.getString("image")

                        var m = Model()
                        m.gift_name=gift_name
                        m.gift_price=gift_price
                        m.image=image
                        list.add(m)

                    }


                }
                catch(e:Exception)
                {
                    e.printStackTrace()
                }

                var myAdapter = MyAdapter(applicationContext,list)
                listView.adapter=myAdapter
            },
            {
              Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
            })

            var queue:RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringRequest)


    }
}