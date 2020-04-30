package com.example.dissertation.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dissertation.Models.Fight
import com.example.dissertation.R
import com.example.dissertation.ViewPager.TournamentPagerAdapter
import kotlinx.android.synthetic.main.activity_tournament.*

class TournamentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tournament)

        val bundle: Bundle = intent.extras as Bundle
        val listFight: ArrayList<Fight> = bundle.getSerializable("bundleFight") as ArrayList<Fight>

        val mPagerAdapter = TournamentPagerAdapter(supportFragmentManager, listFight)
        pager.adapter = mPagerAdapter
    }
}
