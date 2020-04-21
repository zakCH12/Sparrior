package com.example.dissertation.ViewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.dissertation.Database.PersonListAdapter
import com.example.dissertation.Fragment.TournamentColumnFragment

class TournamentPagerAdapter(fm: FragmentManager, private val listPerson: List<String>) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return TournamentColumnFragment(testList1)
            1 -> return TournamentColumnFragment(testList2)
            //2 -> return PersonListAdapter(listPerson)
            //3 -> return PersonListAdapter(listPerson)
            //4 -> return PersonListAdapter(listPerson)
        }
        return TournamentColumnFragment(listPerson)
    }

    override fun getCount(): Int {
        return listPerson.size
    }

    val testList1: List<String> = listOf("RecyclerView 1", "RecyclerView 1")
    val testList2: List<String> = listOf("RecyclerView 2", "RecyclerView 2", "RecyclerView 2")

}