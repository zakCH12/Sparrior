package com.example.dissertation.Database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dissertation.R
import com.google.android.material.snackbar.Snackbar

class PersonListAdapter(private val personList: List<String>) : RecyclerView.Adapter<PersonListAdapter.PersonViewHolder>() {

    class PersonViewHolder(layout : View) : RecyclerView.ViewHolder(layout) {
        var person : TextView = layout.findViewById<View>(R.id.person_name) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.person_layout, parent, false)
        return PersonViewHolder(v)

    }


    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val info = personList[position]

        holder.person.text = info
        holder.person.setOnClickListener {v ->
            val snackbar = Snackbar.make(v, "You clicked on $info", Snackbar.LENGTH_LONG)
            snackbar.show()
        }
    }
}