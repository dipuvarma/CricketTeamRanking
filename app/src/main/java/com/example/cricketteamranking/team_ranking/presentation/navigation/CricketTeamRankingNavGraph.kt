package com.example.cricketteamranking.team_ranking.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.cricketteamranking.team_ranking.presentation.screens.CricketTypeScreen
import com.example.cricketteamranking.team_ranking.presentation.screens.TeamRankingScreen
import com.example.cricketteamranking.team_ranking.presentation.viewModel.CricketRankingViewModel
import kotlin.reflect.typeOf

@Composable
fun CricketTeamRankingNavGraph(viewModel: CricketRankingViewModel) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = CricketType) {
        composable<CricketType> {
            CricketTypeScreen(navController = navController)
        }
        composable<TeamRanking> {
            val arg = it.toRoute<TeamRanking>()
            TeamRankingScreen(
                cricketVM = viewModel,
                type = arg.type,
                gender = arg.gender
            )
        }
    }
}