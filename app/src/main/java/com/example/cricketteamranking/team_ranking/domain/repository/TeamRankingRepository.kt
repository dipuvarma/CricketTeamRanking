package com.example.cricketteamranking.team_ranking.domain.repository

import com.example.cricketteamranking.team_ranking.domain.model.TeamRankingUI
import kotlinx.coroutines.flow.Flow

interface TeamRankingRepository {

    fun getTeamRankingByTypeAndGender(type: String, gender: String): Flow<List<TeamRankingUI>>

}