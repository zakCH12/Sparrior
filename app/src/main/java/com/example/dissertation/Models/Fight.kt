package com.example.dissertation.Models


import java.io.Serializable


class Fight(red: String, blue: String): Serializable{

    val redName = red
    val blueName = blue
    var redScore: Int = 0
    var blueScore: Int = 0
    var clickable: Boolean = true

}