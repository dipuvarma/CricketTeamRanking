package com.example.cricketteamranking.team_ranking.data.remote.api.cricket_api

import com.example.cricketteamranking.core.utils.CRICKET_API_KEY
import com.example.cricketteamranking.team_ranking.data.dto.team_ranking_dto.TeamRankingDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CricketApiService {

    @GET("team-rankings")
    fun getCricketTeamRankingByTpeAndGender(
        @Query("api_token") apiToken: String = CRICKET_API_KEY,
        @Query("filter[gender]") gender: String,
        @Query("filter[type]") type: String,
    ): Call<TeamRankingDTO>
}