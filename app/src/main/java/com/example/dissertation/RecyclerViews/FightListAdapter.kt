package com.example.dissertation.RecyclerViews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dissertation.Models.Fight
import com.example.dissertation.R
import com.google.android.material.snackbar.Snackbar

class FightListAdapter (private val fightList: List<Fight>) : RecyclerView.Adapter<FightListAdapter.FightViewHolder>() {

    class FightViewHolder(layout : View) : RecyclerView.ViewHolder(layout) {
        var redFighter : TextView = layout.findViewById<View>(R.id.red_fighter) as TextView
        var blueFighter : TextView = layout.findViewById<View>(R.id.blue_fighter) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FightViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.fight_layout, parent, false)
        return FightViewHolder(v)

    }


    override fun getItemCount(): Int {
        return fightList.size
    }

    override fun onBindViewHolder(holder: FightViewHolder, position: Int) {
        val fightInfo = fightList[position]


        holder.redFighter.text = fightInfo.redName
        holder.blueFighter.text = fightInfo.blueName
        holder.redFighter.setOnClickListener {v ->
            val snackbar = Snackbar.make(v, "You clicked on ${fightInfo.redName}", Snackbar.LENGTH_LONG)
            snackbar.show()
        }
        holder.blueFighter.setOnClickListener {v ->
            val snackbar = Snackbar.make(v, "You clicked on ${fightInfo.blueName}", Snackbar.LENGTH_LONG)
            snackbar.show()
        }
    }
}