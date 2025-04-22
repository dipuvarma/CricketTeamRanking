package com.example.cricketteamranking.team_ranking.data.remote.api.cricket_api

import com.example.cricketteamranking.core.utils.CRICKET_API_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CricketApiRetrofitClient {

    val cricketApiRetrofitClient = Retrofit.Builder()
        .baseUrl(CRICKET_API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CricketApiService::class.java)
}


