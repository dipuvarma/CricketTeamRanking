package com.example.cricketteamranking.team_ranking.presentation.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.SportsCricket
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cricketteamranking.R
import com.example.cricketteamranking.core.presentaion.component.IconAndTextComp
import com.example.cricketteamranking.core.presentaion.component.TeamRankingComp
import com.example.cricketteamranking.team_ranking.presentation.viewModel.CricketRankingViewModel
import com.example.cricketteamranking.team_ranking.presentation.viewModel.OnEvent

@Composable
fun TeamRankingScreen(
    cricketVM: CricketRankingViewModel,
    type: String,
    gender: String,
) {
    val state = cricketVM.state.collectAsState().value

    LaunchedEffect(key1 = Unit) {
        cricketVM.event(OnEvent.GetTeamRanking(type, gender))
    }

    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(8.dp)
        ) {
            item {
                Text(text = "Currently update at")
                Spacer(modifier = Modifier.height(8.dp))
            }
            items(items = state.data, key = { it.id }) { data ->
                TeamRankingComp(
                    image = R.drawable.ic_launcher_background,
                    name = data.name,
                    matches = data.ranking.matches,
                    points = data.ranking.points,
                    rating = data.ranking.rating,
                    position = data.ranking.position
                )
            }
        }
    }

}


