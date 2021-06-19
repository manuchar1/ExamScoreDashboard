package com.tbcacademy.examscoredashboard.models


import androidx.annotation.Keep

@Keep
data class MatchSummary(
    val summaries: List<Summary>
)