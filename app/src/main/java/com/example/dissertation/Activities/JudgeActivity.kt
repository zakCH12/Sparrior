package com.example.dissertation.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import android.widget.Toast
import com.example.dissertation.Models.Fight
import com.example.dissertation.R
import kotlinx.android.synthetic.main.activity_judge.*

class JudgeActivity : AppCompatActivity() {

    private var round = 0
    private var scoreRed = 0
    private var scoreBlue = 0
    private var timeLeftMs: Long = 120000 //2min
    private var timerIsRunning = false
    private var position = 0
    private var isTournament = true
    lateinit var fightList: ArrayList<Fight>
    lateinit var context: Context
    lateinit var countDownTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_judge)
        context = this
        val bundle: Bundle = intent.extras as Bundle
        fightList = bundle.getSerializable("fightList") as ArrayList<Fight>
        position = intent.getIntExtra("position", 0)

        btn_start_stop.setBackgroundResource(R.drawable.start)
        red_name.text = fightList[position].redName
        blue_name.text = fightList[position].blueName

        plus1_red.setOnClickListener {
            if (!timerIsRunning) {
                val toast = Toast.makeText(applicationContext, "Timer is stopped", Toast.LENGTH_LONG)
                toast.show()
            } else {
                scoreRed += 1
                updateScore()
            }
        }

        plus2_red.setOnClickListener {
            if (!timerIsRunning) {
                val toast = Toast.makeText(applicationContext, "Timer is stopped", Toast.LENGTH_LONG)
                toast.show()
            } else {
                scoreRed += 2
                updateScore()
            }
        }

        plus3_red.setOnClickListener {
            if (!timerIsRunning) {
                val toast = Toast.makeText(applicationContext, "Timer is stopped", Toast.LENGTH_LONG)
                toast.show()
            } else {
                scoreRed += 3
                updateScore()
            }
        }

        plus4_red.setOnClickListener {
            if (!timerIsRunning) {
                val toast = Toast.makeText(applicationContext, "Timer is stopped", Toast.LENGTH_LONG)
                toast.show()
            } else {
                scoreRed += 4
                updateScore()
            }
        }

        minus1_red.setOnClickListener {
            if (!timerIsRunning) {
                val toast = Toast.makeText(applicationContext, "Timer is stopped", Toast.LENGTH_LONG)
                toast.show()
            } else {
                scoreRed -= 1
                updateScore()
            }
        }


        plus1_blue.setOnClickListener {
            if (!timerIsRunning) {
                val toast = Toast.makeText(applicationContext, "Timer is stopped", Toast.LENGTH_LONG)
                toast.show()
            } else {
                scoreBlue += 1
                updateScore()
            }
        }

        plus2_blue.setOnClickListener {
            if (!timerIsRunning) {
                val toast = Toast.makeText(applicationContext, "Timer is stopped", Toast.LENGTH_LONG)
                toast.show()
            } else {
                scoreBlue += 2
                updateScore()
            }
        }

        plus3_blue.setOnClickListener {
            if (!timerIsRunning) {
                val toast = Toast.makeText(applicationContext, "Timer is stopped", Toast.LENGTH_LONG)
                toast.show()
            } else {
                scoreBlue += 3
                updateScore()
            }
        }

        plus4_blue.setOnClickListener {
            if (!timerIsRunning) {
                val toast = Toast.makeText(applicationContext, "Timer is stopped", Toast.LENGTH_LONG)
                toast.show()
            } else {
                scoreBlue += 4
                updateScore()
            }
        }

        minus1_blue.setOnClickListener {
            if (!timerIsRunning) {
                val toast = Toast.makeText(applicationContext, "Timer is stopped", Toast.LENGTH_LONG)
                toast.show()
            } else {
                scoreBlue -= 1
                updateScore()
            }
        }

        btn_start_stop.setOnClickListener {
            startStop()
        }
    }

    private fun updateScore() {
        score_red.text = "$scoreRed"
        score_blue.text= "$scoreBlue"
    }

    private fun startStop() {
        if (!timerIsRunning) {
            startTimer()
            timerIsRunning = true
        } else {stopTimer()
            timerIsRunning = false
        }
    }

    private fun startTimer() {
        println("Timer started")
        countDownTimer = object: CountDownTimer(timeLeftMs, 1000) {
            override fun onFinish() {
                if (checkRound()) {
                    if (!isTournament) {
                    } else {
                        setScore()
                        val intent = Intent(context, TournamentActivity::class.java)
                        val bundle = Bundle()
                        bundle.putSerializable("bundleFight", fightList)
                        intent.putExtras(bundle)
                        startActivity(intent)
                    }
                } else {
                    timeLeftMs = 5000
                    stopTimer()
                }
            }

            override fun onTick(millisUntilFinished: Long) {
                timeLeftMs = millisUntilFinished
                updateTimer()
                println(timeLeftMs)
            }

        }.start()
        btn_start_stop.setBackgroundResource(R.drawable.pause)
    }

    private fun stopTimer() {
        countDownTimer.cancel()
        timerIsRunning = false
        btn_start_stop.setBackgroundResource(R.drawable.start)

    }

    private fun updateTimer() {
        val minutes = (timeLeftMs / 60000).toInt()
        val seconds = (timeLeftMs % 60000 / 1000).toInt()

        var timeLeftText: String = "$minutes:"
        if (seconds < 10) timeLeftText += "0"
        timeLeftText += seconds
        countdown_text.text = timeLeftText
    }

    private fun checkRound(): Boolean {
        println("Round complete")
        return if(round<3) {
            round++
            txt_round.text = "Round: $round"
            false
        } else if(round == 3 && scoreRed == scoreBlue){
            suddenDeath()
            false
        } else {
            checkScore()
            true
        }
    }

    private fun checkScore() {
        when {
            scoreRed > scoreBlue -> {
                val toast = Toast.makeText(applicationContext, "Red is the winner", Toast.LENGTH_LONG)
                toast.show()
            }
            else -> {
                val toast = Toast.makeText(applicationContext, "Blue is the winner", Toast.LENGTH_LONG)
                toast.show()
            }
        }
    }

    private fun suddenDeath() {

    }

    private fun setScore() {
        fightList[position].redScore = scoreRed
        fightList[position].blueScore = scoreBlue
    }
}
