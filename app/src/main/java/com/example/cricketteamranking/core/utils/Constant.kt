package com.example.cricketteamranking.core.utils

import com.example.cricketteamranking.team_ranking.domain.model.CricketFormat


const val CRICKET_API_BASE_URL = "https://cricket.sportmonks.com/api/v2.0/"

const val CRICKET_API_KEY = "gtS5BZ1VomIYt9hqKA759sUDk4rqrVG9oLsBHwoy9r7T4BpqWAtBFEnN9zFH"

val cricketTypeAndGender = listOf(
    CricketFormat(
        type = "ODI",
        gender = "men"
    ),
    CricketFormat(
        type = "ODI",
        gender = "women"
    ),
    CricketFormat(
        type = "T20I",
        gender = "women"
    ),
    CricketFormat(
        type = "T20I",
        gender = "men"
    ),
    CricketFormat(
        type = "TEST",
        gender = "men"
    ),
    CricketFormat(
        type = "TEST",
        gender = "women"
    )
)