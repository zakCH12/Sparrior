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
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_tournament.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
        btn_spar.setOnClickListener {
            val intent = Intent(this, SparActivity::class.java)
            startActivity(intent)
        }
    }
}
