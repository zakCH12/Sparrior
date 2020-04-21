package com.example.dissertation.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dissertation.Database.PersonDBHelper
import com.example.dissertation.Models.Fight
import com.example.dissertation.R
import com.example.dissertation.ViewPager.TournamentPagerAdapter
import kotlinx.android.synthetic.main.activity_tournament.*

class TournamentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tournament)

        val personDB = PersonDBHelper(this)
        val listPerson = personDB.allPerson()
        val listFight = pairPeople(listPerson)

        val mPagerAdapter = TournamentPagerAdapter(supportFragmentManager, listFight)
        pager.adapter = mPagerAdapter
    }

    private fun pairPeople(listPerson: List<String>) : List<Fight> {
        var listFight = ArrayList<Fight>()
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
