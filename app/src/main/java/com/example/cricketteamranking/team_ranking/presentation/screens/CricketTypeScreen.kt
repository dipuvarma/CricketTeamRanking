package com.example.cricketteamranking.team_ranking.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cricketteamranking.core.presentaion.component.CricketFormatItem
import com.example.cricketteamranking.core.utils.cricketTypeAndGender
import com.example.cricketteamranking.team_ranking.presentation.navigation.TeamRanking

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CricketTypeScreen(
    navController: NavHostController,
) {
    Column(
        modifier = Modifier
            .statusBarsPadding()
    ) {
        TopAppBar(
            title = {
                Text(text = "Cricket Ranking")
            }
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(colors = listOf(Color.Blue, Color.Red)),
                    alpha = 0.8f
                ),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Text(
                    text = buildAnnotatedString {
                        append("Cricket Ranking Of ")
                        withStyle(
                            style = SpanStyle(
                                color = Color.White,
                                fontSize = 18.sp,
                                textDecoration = TextDecoration.Underline,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("Men's")
                        }
                        append(" and ")
                        withStyle(
                            style = SpanStyle(
                                color = Color.White,
                                fontSize = 18.sp,
                                textDecoration = TextDecoration.Underline,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("Women's")
                        }
                        append(" Teams Ranking")
                    },
                    modifier = Modifier.basicMarquee(
                        iterations = Int.MAX_VALUE,
                        initialDelayMillis = 2000
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalItemSpacing = 16.dp
                ) {
                    items(cricketTypeAndGender) {
                        CricketFormatItem(it) {
                            navController.navigate(route = TeamRanking(type = it.type, gender = it.gender))
                        }
                    }
                }
            }

        }
    }
}


