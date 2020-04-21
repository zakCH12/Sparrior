package com.example.dissertation.ViewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.dissertation.Fragment.TournamentColumnFragment
import com.example.dissertation.Models.Fight

class TournamentPagerAdapter(fm: FragmentManager, private val listFight: List<Fight>) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        println("Position is " + position)
        when (position) {
            0 -> return TournamentColumnFragment(listFight)
            1 -> return TournamentColumnFragment(quarterfinals)
            2 -> return TournamentColumnFragment(semifinals)
            3 -> return TournamentColumnFragment(final)
        }
        return TournamentColumnFragment(listFight)
    }

    override fun getCount(): Int {
        return listFight.size
    }

    val quarterfinals: List<Fight> = listOf(Fight("TBD","TBD"),Fight("TBD","TBD"),Fight("TBD","TBD"),Fight("TBD","TBD"))
    val semifinals: List<Fight> = listOf(Fight("TBD","TBD"),Fight("TBD","TBD"))
    val final: List<Fight> = listOf(Fight("TBD","TBD"))

}