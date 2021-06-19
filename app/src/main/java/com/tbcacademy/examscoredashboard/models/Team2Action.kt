package com.tbcacademy.examscoredashboard.models


import androidx.annotation.Keep

@Keep
data class Team2Action(
    val action: ActionX,
    val actionType: Int,
    val teamType: Int
)