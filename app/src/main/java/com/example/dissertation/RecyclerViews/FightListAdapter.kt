package com.example.dissertation.RecyclerViews

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dissertation.Activities.JudgeActivity
import com.example.dissertation.Models.Fight
import com.example.dissertation.R
import kotlinx.android.synthetic.main.activity_tournament.*

class FightListAdapter (private val fightList: ArrayList<Fight>) : RecyclerView.Adapter<FightListAdapter.FightViewHolder>() {

    class FightViewHolder(layout : View) : RecyclerView.ViewHolder(layout) {

        var redFighter : TextView = layout.findViewById<View>(R.id.red_fighter) as TextView
        var blueFighter : TextView = layout.findViewById<View>(R.id.blue_fighter) as TextView
        var redFighterScore : TextView = layout.findViewById<View>(R.id.red_score) as TextView
        var blueFighterScore : TextView = layout.findViewById<View>(R.id.blue_score) as TextView
        val context = layout.context

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
        holder.redFighterScore.text = "" + fightInfo.redScore
        holder.blueFighter.text = fightInfo.blueName
        holder.blueFighterScore.text = "" + fightInfo.blueScore
        holder.itemView.setOnClickListener {
            if (fightInfo.clickable) {
                fightInfo.clickable = false
                val intent = Intent(holder.context, JudgeActivity::class.java)
                val bundle = Bundle()
                bundle.putSerializable("fightList", fightList)
                intent.putExtra("position", position)
                intent.putExtra("tournament", true)
                intent.putExtras(bundle)
                holder.context.startActivity(intent)
            }
        }
    }


}