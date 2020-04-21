package com.example.dissertation.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dissertation.Database.PersonListAdapter
import com.example.dissertation.R
import java.util.ArrayList

class TournamentColumnFragment(listPerson: List<String>) : Fragment() {

    lateinit var tournamentColumn: RecyclerView
    var listPerson: List<String> = listPerson

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val v = inflater.inflate(R.layout.tournament_round, container, false)
        tournamentColumn = v.findViewById(R.id.recyclerview_person)
        val adapter = PersonListAdapter(listPerson)
        val layoutManager = LinearLayoutManager(getActivity())
        tournamentColumn.layoutManager = layoutManager
        tournamentColumn.adapter = adapter
        return v
    }
}