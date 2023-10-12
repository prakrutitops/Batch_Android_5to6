package tops.tech.retrofitcrudex

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var edt3:EditText
    lateinit var btn1:Button
    lateinit var apiinterface: Apiinterface

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        edt1 = findViewById(R.id.edtname)
        edt2 = findViewById(R.id.edtprice)
        edt3 = findViewById(R.id.edtdes)
        btn1 = findViewById(R.id.btnupdate)

        var i = intent
        var id = i.getIntExtra("id",101)
        var name =  i.getStringExtra("name")
        var price = i.getStringExtra("price")
        var des =  i.getStringExtra("des")

        edt1.setText(name)
        edt2.setText(price)
        edt3.setText(des)


       apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)

        btn1.setOnClickListener {

            var name = edt1.text.toString()
            var price = edt2.text.toString()
            var des = edt3.text.toString()

           var call: Call<Void> = apiinterface.updatedata(id,name,price,des)

           call.enqueue(object :Callback<Void>{
               override fun onResponse(call: Call<Void>, response: Response<Void>)
               {
                Toast.makeText(applicationContext,"Updated",Toast.LENGTH_LONG).show()
                   startActivity(Intent(applicationContext,ViewActivity::class.java))
               }

               override fun onFailure(call: Call<Void>, t: Throwable) {
                   Toast.makeText(applicationContext,"Fail",Toast.LENGTH_LONG).show()
               }
           })

        }

    }
}