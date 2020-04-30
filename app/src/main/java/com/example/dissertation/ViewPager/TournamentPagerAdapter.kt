package com.example.dissertation.ViewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.dissertation.Fragment.TournamentColumnFragment
import com.example.dissertation.Models.Fight

class TournamentPagerAdapter(fm: FragmentManager, private val listFight: ArrayList<Fight>) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        println("Position is $position")
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

    private fun makeNextRound(previousRound: ArrayList<Fight>): ArrayList<Fight> {
        val listWinners = ArrayList<String>()
        for (fight in previousRound) {
            listWinners.add(findWinner(fight))
        }
        return pairPeople(listWinners)
    }

    private fun findWinner(fight: Fight): String {
        println("Red score is ${fight.redScore} \n Blue score is ${fight.blueScore}")
        return when {
            fight.blueScore < fight.redScore -> fight.redName
            fight.blueScore > fight.redScore -> fight.blueName
            else -> "TBD"

        }
    }

    private fun pairPeople(listPerson: ArrayList<String>) : ArrayList<Fight> {
        val listFight = ArrayList<Fight>()
        for (item in listPerson.indices) {
            var red: String
            var blue: String
            if (item % 2 != 0) {
                blue = listPerson[item]
                red = listPerson[item - 1]
                val fight = Fight(red, blue)
                listFight.add(fight)
            }
        }
        return listFight
    }
    private val quarterfinals: ArrayList<Fight> = makeNextRound(listFight)
    private val semifinals: ArrayList<Fight> = makeNextRound(quarterfinals)
    private val final: ArrayList<Fight> = makeNextRound(semifinals)

}