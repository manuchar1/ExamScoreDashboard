package com.tbcacademy.examscoredashboard.models


import androidx.annotation.Keep

@Keep
data class Summary(
    val actionTime: String,
    val team1Action: List<Team1Action>,
    val team2Action: List<Team2Action>
)