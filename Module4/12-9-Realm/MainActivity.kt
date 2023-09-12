package tops.tech.realmex

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import io.realm.Realm

class MainActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var realm: Realm

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        realm = Realm.getInstance(Realm.getDefaultConfiguration())
        btn1.setOnClickListener {


            var name = edt1.text.toString()
            var num = edt2.text.toString()

            realm.beginTransaction()

            var m = realm.createObject(Model::class.java)
            m.name=name
            m.number=num

            realm.commitTransaction()

            Toast.makeText(applicationContext,"Inseretd",Toast.LENGTH_SHORT).show()

        }

        btn2.setOnClickListener {

            startActivity(Intent(applicationContext,MainActivity2::class.java))
        }

    }
}