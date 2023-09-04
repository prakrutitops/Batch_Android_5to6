package com.example.sqlitedb

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context:Context) : SQLiteOpenHelper(context,DB_NAME,null,DB_VERSION)
{
    companion object
    {
        var DB_NAME="tops.db"
        var TABLE_NAME="details"
        var ID="id"
        var NAME="name"
        var NUMBER="number"
        var DB_VERSION=1
    }


    override fun onCreate(db: SQLiteDatabase?)
    {
        //var query ="create table "+ TABLE_NAME+"("+ ID +" INTEGER PRIMARY KEY ,"+ NAME +" text, "+ NUMBER+" text "+")"
        var query ="CREATE TABLE " + TABLE_NAME + "("+ ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"+ NUMBER + " TEXT" + ")"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    {
       var upquery ="DROP TABLE IF EXIST "+ TABLE_NAME
        db!!.execSQL(upquery)
        onCreate(db)
    }

    //insert
    fun insertdata(m:Model) :Long
    {
        var db = writableDatabase
        var values = ContentValues()//data insert
        values.put(NAME,m.name)//get
        values.put(NUMBER,m.num)//get
        var a = db.insert(TABLE_NAME,ID,values)
        return a
    }

    //view
    fun viewdata() :ArrayList<Model>
    {
        var list:ArrayList<Model> = ArrayList()
        var db = readableDatabase
        var col = arrayOf(ID, NAME, NUMBER)
        var cursor:Cursor = db.query(TABLE_NAME,col,null,null,null,null,null,null)
        while (cursor.moveToNext())
        {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var num = cursor.getString(2)

            var m = Model()
            m.id=id
            m.name=name
            m.num=num

            list.add(m)
        }
        return list
    }

    fun deletedata(id:Int)
    {
        var db = writableDatabase
        var deletequery = ID+"="+id
        db.delete(TABLE_NAME,deletequery,null)
    }

    //update
    fun updatedata(m:Model)
    {
        var db = writableDatabase
        var values = ContentValues()//data update
        values.put(ID,m.id)
        values.put(NAME,m.name)//get
        values.put(NUMBER,m.num)//get
        var upquery = ID+"="+m.id
        db.update(TABLE_NAME,values,upquery,null)

    }

}