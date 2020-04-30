package com.example.dissertation.Database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.dissertation.Models.Person

class PersonDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER) {
    override fun onCreate(db: SQLiteDatabase?) {
        //SQLite query
        val CREATE_TABLE_QUERY =("CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL_NAME TEXT NOT NULL)")
        db!!.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    companion object {

        private val DATABASE_NAME = "ZCHDB.db"
        private val DATABASE_VER = 2

        //Table
        private val TABLE_NAME = "person"
        private val COL_ID = "pid"
        private val COL_NAME = "name"
    }


    fun addPerson(person: Person) {

        val db = this.writableDatabase
        val values = ContentValues()


        values.put(COL_NAME, person.name)

        db.insert(TABLE_NAME, null, values)
        db.close()
        println("Person added to database")
    }

    fun deleteData() {

        val db = this.writableDatabase
        db!!.execSQL("DELETE FROM $TABLE_NAME")
    }


    fun allPerson() : ArrayList<String> {
        println("allPersonStarted")
        val listPerson = ArrayList<String>()
        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {

            do {

                val name = cursor.getString(cursor.getColumnIndex(COL_NAME))
                listPerson.add(name)

            } while (cursor.moveToNext())
        }
        println(listPerson)
        return listPerson
    }
}