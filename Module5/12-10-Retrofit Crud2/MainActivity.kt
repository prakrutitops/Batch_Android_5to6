package tops.tech.retrofitcrudex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var edt3:EditText
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var apiinterface: Apiinterface

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edtname)
        edt2 = findViewById(R.id.edtprice)
        edt3 = findViewById(R.id.edtdes)
        btn1 = findViewById(R.id.btninsert)
        btn2 = findViewById(R.id.btnview)

        apiinterface=  ApiClient.getapiclient().create(Apiinterface::class.java)

        btn1.setOnClickListener {

            var name = edt1.text.toString()
            var price = edt2.text.toString()
            var des = edt3.text.toString()

           var call: Call<Void> =  apiinterface.insertdata(name,price,des)

            call.enqueue(object:Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                   Toast.makeText(applicationContext,"Inserted",Toast.LENGTH_LONG).show()

                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext,"Fail",Toast.LENGTH_LONG).show()
                }
            })


        }

        btn2.setOnClickListener {


            startActivity(Intent(applicationContext,ViewActivity::class.java))

        }





    }
}