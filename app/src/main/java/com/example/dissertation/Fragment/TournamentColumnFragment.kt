package com.example.dissertation.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dissertation.Models.Fight
import com.example.dissertation.R
import com.example.dissertation.RecyclerViews.FightListAdapter

class TournamentColumnFragment(var listFight: ArrayList<Fight>) : Fragment() {

    lateinit var tournamentColumn: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val v = inflater.inflate(R.layout.tournament_round, container, false)
        tournamentColumn = v.findViewById(R.id.recyclerview_fight)
        val adapter = FightListAdapter(listFight)
        val layoutManager = LinearLayoutManager(activity)
        tournamentColumn.layoutManager = layoutManager
        tournamentColumn.adapter = adapter
        return v
    }


}