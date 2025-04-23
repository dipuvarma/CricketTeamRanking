package com.example.cricketteamranking.team_ranking.presentation.navigation

import kotlinx.serialization.Serializable


@Serializable
object CricketType


@Serializable
data class TeamRanking(
    val type: String,
    val gender: String,
)