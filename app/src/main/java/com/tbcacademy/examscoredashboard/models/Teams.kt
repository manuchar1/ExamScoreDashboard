package com.tbcacademy.examscoredashboard.models


import androidx.annotation.Keep

@Keep
data class Teams(
    val match: Match,
    val resultCode: Int
)