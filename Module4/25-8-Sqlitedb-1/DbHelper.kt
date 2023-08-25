package com.example.sqlitedb

import android.content.ContentValues
import android.content.Context
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

    fun insertdata(m:Model) :Long
    {
        var db = writableDatabase
        var values = ContentValues()//data insert
        values.put(NAME,m.name)//get
        values.put(NUMBER,m.num)//get
        var id = db.insert(TABLE_NAME,ID,values)
        return id
    }

}