package tops.tech.realmex

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import io.realm.Realm

class MainActivity2 : AppCompatActivity()
{
    lateinit var listview:ListView
    lateinit var list:MutableList<Model>
    lateinit var realm: Realm
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        listview = findViewById(R.id.list)
        list = ArrayList()
        realm = Realm.getInstance(Realm.getDefaultConfiguration())

        //detail get

        realm.beginTransaction()
        var realmresults = realm.where(Model::class.java).findAll()

        for(i in realmresults.indices)
        {
           list.add(realmresults[i]!!)
        }

        var adapter = MyAdapter(applicationContext,list)
        listview.adapter=adapter


        realm.commitTransaction()

        listview.setOnItemClickListener { parent, view, position, id ->

            var alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Select Operations?")
            alertDialog.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->


                var alertDialog2 = AlertDialog.Builder(this)
                var layout = LayoutInflater.from(applicationContext)
                var view = layout.inflate(R.layout.edit,null)
                alertDialog2.setView(view)
                var edt1:EditText = view.findViewById(R.id.edt1)
                var edt2:EditText = view.findViewById(R.id.edt2)
                edt1.setText(list.get(position).name)
                edt2.setText(list.get(position).number)
                alertDialog2.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->

                    realm.beginTransaction()

                        var a = edt1.text.toString()
                        var b = edt2.text.toString()

                        list.get(position).name =a
                        list.get(position).number=b
                    startActivity(Intent(applicationContext,MainActivity2::class.java))
                    realm.commitTransaction()



                })
                alertDialog2.show()


            })
            alertDialog.setNegativeButton("Delete",{ dialogInterface: DialogInterface, i: Int ->

                realm.beginTransaction()

                var realmresults = realm.where(Model::class.java).findAll()
                realmresults.deleteFromRealm(position)

                startActivity(Intent(applicationContext,MainActivity2::class.java))
                realm.commitTransaction()

            })
            alertDialog.show()



        }
    }
}