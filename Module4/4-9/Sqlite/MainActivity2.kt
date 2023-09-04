package com.example.sqlitedb

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog

class MainActivity2 : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var mutableList: MutableList<Model>
    lateinit var dbHelper: DbHelper
    var arraylist:ArrayList<HashMap<String,String>> = ArrayList()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        listView = findViewById(R.id.list)
        mutableList = ArrayList()
        dbHelper = DbHelper(applicationContext)

        mutableList = dbHelper.viewdata()


        for(i in mutableList)
        {
            var hm = HashMap<String,String>()
            hm["NAME"]=i.name
            hm["NUMBER"]=i.num

            arraylist.add(hm)
        }



        var fromarray = arrayOf("NAME","NUMBER")
        var toarray = intArrayOf(R.id.txt1,R.id.txt2)

        var adapter = SimpleAdapter(applicationContext,arraylist,R.layout.design,fromarray,toarray)
        listView.adapter=adapter

        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo)
    {
        var m1 = menu!!.add(0,1,0,"Update")
        var m2 = menu!!.add(0,2,0,"Delete")
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        var acm:AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        var id = acm.position
        var m :Model = mutableList.get(id)


        when(item.itemId)
        {

            1->
            {
                    var i = Intent(applicationContext,UpdateActivity::class.java)
                    i.putExtra("ID",m.id)
                    i.putExtra("NAME",m.name)
                    i.putExtra("NUM",m.num)
                    startActivity(i)
            }
            2->
            {
                var alertDialog = AlertDialog.Builder(this)
                alertDialog.setTitle("Are you sure you want to delete?")
                alertDialog.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

                    dbHelper.deletedata(m.id)
                    startActivity(Intent(applicationContext,MainActivity2::class.java))
                })
                alertDialog.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->

                    dialogInterface.cancel()
                })
                alertDialog.show()
            }

        }
        return super.onContextItemSelected(item)
    }
}