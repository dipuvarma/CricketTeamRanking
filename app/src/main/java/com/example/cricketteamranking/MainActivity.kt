package com.example.cricketteamranking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cricketteamranking.core.presentaion.ui.theme.CricketTeamRankingTheme
import com.example.cricketteamranking.team_ranking.data.repository.TeamRankingRepositoryImpl
import com.example.cricketteamranking.team_ranking.presentation.screens.TeamRankingScreen
import com.example.cricketteamranking.team_ranking.presentation.viewModel.CricketRankingViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel: CricketRankingViewModel by viewModels()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CricketTeamRankingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TeamRankingScreen(
                        viewModel
                    )
                }
            }
        }
    }
}
