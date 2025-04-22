package com.example.cricketteamranking.team_ranking.data.repository


import android.util.Log
import com.example.cricketteamranking.team_ranking.data.dto.team_ranking_dto.TeamRankingDTO
import com.example.cricketteamranking.team_ranking.data.mappers.toTeamRankingUI
import com.example.cricketteamranking.team_ranking.data.remote.api.cricket_api.CricketApiRetrofitClient
import com.example.cricketteamranking.team_ranking.domain.model.TeamRankingUI
import com.example.cricketteamranking.team_ranking.domain.repository.TeamRankingRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamRankingRepositoryImpl : TeamRankingRepository {
    override fun getTeamRankingByTypeAndGender(
        type: String,
        gender: String
    ): Flow<List<TeamRankingUI>> = callbackFlow {

        val teamRankingData =
            CricketApiRetrofitClient.cricketApiRetrofitClient.getCricketTeamRankingByTpeAndGender(
                type = type,
                gender = gender
            )

        teamRankingData.enqueue(
            object : Callback<TeamRankingDTO> {
                override fun onResponse(
                    call: Call<TeamRankingDTO?>,
                    response: Response<TeamRankingDTO?>
                ) {
                    try {
                        if (response.isSuccessful) {
                            val teamRanking = response.body()?.toTeamRankingUI()
                            if (teamRanking != null) {
                                trySend(teamRanking)
                            }
                        }
                    } catch (e: Exception) {
                        close()
                    }
                }

                override fun onFailure(
                    call: Call<TeamRankingDTO?>,
                    t: Throwable
                ) {
                    close()
                }

            }
        )
        awaitClose { }
    }
}