package com.tbcacademy.examscoredashboard.models


import androidx.annotation.Keep

@Keep
data class ActionX(
    val goalType: Int,
    val player: PlayerX,
    val player1: Player1X,
    val player2: Player2X
)