package com.tbcacademy.examscoredashboard.models


import androidx.annotation.Keep

@Keep
data class Team1Action(
    val action: Action,
    val actionType: Int,
    val teamType: Int
)