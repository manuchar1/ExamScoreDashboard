package com.tbcacademy.examscoredashboard.network


import com.tbcacademy.examscoredashboard.models.Teams
import com.tbcacademy.examscoredashboard.utils.Constants.API_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface FootballAPI {

    @GET(API_ENDPOINT)
    suspend fun getData(): Response<Teams>


}