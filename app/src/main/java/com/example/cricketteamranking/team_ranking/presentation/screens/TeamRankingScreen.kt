package com.example.cricketteamranking.team_ranking.presentation.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.cricketteamranking.team_ranking.presentation.viewModel.CricketRankingViewModel

@Composable
fun TeamRankingScreen(
    cricketVM: CricketRankingViewModel
) {

    val state = cricketVM.state.collectAsState().value

    val data = state.data.map {

    }

}