package com.tbcacademy.examscoredashboard.models


import androidx.annotation.Keep

@Keep
data class Team1(
    val ballPosition: Int,
    val score: Int,
    val teamImage: String,
    val teamName: String
)