package tops.tech.signupsigninex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import tops.tech.signupsigninex.databinding.ActivityLoginBinding
import tops.tech.signupsigninex.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnlogin.setOnClickListener {

            var mobile = binding.edtmob.text.toString()
            var pass = binding.edtpass.text.toString()


            var stringRequest:StringRequest = object:StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/login.php", {response->

                try
                {
                    if(response.trim().equals("0"))
                    {
                        Toast.makeText(applicationContext,"Login fail",Toast.LENGTH_LONG).show()
                    }
                    else
                    {
                        Toast.makeText(applicationContext,"Login Success",Toast.LENGTH_LONG).show()
                    }
                }
                catch (e:java.lang.Exception)
                {
                    e.printStackTrace()
                }




            },Response.ErrorListener {

                Toast.makeText(applicationContext,"Login Fail",Toast.LENGTH_LONG).show()
            })

            {
                override fun getParams(): MutableMap<String, String>? {

                    var map = HashMap<String,String>()

                    map["mobile"]=mobile
                    map["password"]=pass

                    return map
                }
            }
            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringRequest)

        }
    }
}