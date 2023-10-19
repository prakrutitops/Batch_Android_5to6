package tops.tech.retrofitregisterlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tops.tech.retrofitregisterlogin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var apiinterface: Apiinterface
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)


        binding.btnlogin.setOnClickListener {

            var mob = binding.edtmob.text.toString()
            var pass = binding.edtpass.text.toString()

          var call: Call<RegisterModel> = apiinterface.logincheck(mob,pass)
           call.enqueue(object :Callback<RegisterModel>{
               override fun onResponse(call: Call<RegisterModel>, response: Response<RegisterModel>
               )
               {
                    Toast.makeText(applicationContext,"Logged in succesfully",Toast.LENGTH_LONG).show()
               }

               override fun onFailure(call: Call<RegisterModel>, t: Throwable) {

                   Toast.makeText(applicationContext,"Logged in Error",Toast.LENGTH_LONG).show()
               }
           })
        }



    }
}