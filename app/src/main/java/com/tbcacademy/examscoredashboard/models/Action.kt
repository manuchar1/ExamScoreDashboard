package com.tbcacademy.examscoredashboard.models


import androidx.annotation.Keep

@Keep
data class Action(
    val goalType: Int,
    val player: Player,
    val player1: Player1,
    val player2: Player2
)