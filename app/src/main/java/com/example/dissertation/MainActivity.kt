package com.example.dissertation

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dissertation.Database.PersonDBHelper
import com.example.dissertation.Database.PersonListAdapter
import com.example.dissertation.Model.Person
import com.example.dissertation.ViewPager.TournamentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var personDB : PersonDBHelper
    private var listPerson : List<String> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val recyclerView = findViewById<View>(R.id.recyclerview_person) as RecyclerView
        //val layoutManager = LinearLayoutManager(this)
        //recyclerView.layoutManager = layoutManager
        personDB = PersonDBHelper(this)
        refreshData()


        btn_add.setOnClickListener {

            val name: String = edit_text_name.text.toString()
            if (name.trim().isEmpty()) {
                println("Name is empty")
                val toast = Toast.makeText(applicationContext, "Please enter name", Toast.LENGTH_LONG)
                toast.show()
            } else {
                println("Button pressed")
                val person = Person(name)
                personDB.addPerson(person)
                edit_text_name.text.clear()
                refreshData()
            }
        }
    }

    private fun refreshData() {
        listPerson = personDB.allPerson()
        println(listPerson)
        val mPagerAdapter = TournamentPagerAdapter(supportFragmentManager, listPerson)
        pager.adapter = mPagerAdapter
        //val mAdapter = PersonListAdapter(listPerson)
        //recyclerview_person.adapter = mAdapter
    }
}
