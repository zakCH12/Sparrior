package com.example.dissertation.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dissertation.Database.PersonDBHelper
import com.example.dissertation.Models.Fight
import com.example.dissertation.Models.Person
import com.example.dissertation.R
import com.example.dissertation.RecyclerViews.PersonListAdapter
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    private lateinit var personDB : PersonDBHelper
    private var listPerson : ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val recyclerView = findViewById<View>(R.id.recyclerview_person) as RecyclerView
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
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

        btn_delete.setOnClickListener {
            personDB.deleteData()
            val toast = Toast.makeText(applicationContext, "Data deleted", Toast.LENGTH_LONG)
            toast.show()
            refreshData()
        }

        btn_next.setOnClickListener {
            if (listPerson.size != 16) {
                val toast = Toast.makeText(applicationContext, "Need 16 participants", Toast.LENGTH_LONG)
                toast.show()
            } else {
                val intent = Intent(this, TournamentActivity::class.java)
                val bundle = Bundle()
                bundle.putSerializable("bundleFight", pairPeople(listPerson))
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    private fun refreshData() {
        listPerson = personDB.allPerson()
        println(listPerson)
        val mAdapter = PersonListAdapter(listPerson)
        recyclerview_person.adapter = mAdapter
    }

    private fun pairPeople(listPerson: ArrayList<String>) : ArrayList<Fight> {
        val listFight = ArrayList<Fight>()
        for (item in listPerson.indices) {
            var red: String
            var blue: String
            if (item % 2 == 0) {
                red = listPerson[item]
                blue = listPerson[item + 1]
                val fight = Fight(red, blue)
                listFight.add(fight)
            }
        }
        return listFight
    }
}
