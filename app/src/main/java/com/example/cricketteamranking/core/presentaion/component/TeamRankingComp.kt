package com.example.cricketteamranking.core.presentaion.component

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.SportsCricket
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun TeamRankingComp(
    image: Int,
    name: String,
    matches:Int,
    points: Int,
    rating: Int,
    position: Int
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .height(130.dp)
            .padding(8.dp)
            .background(color = Color.Magenta, shape = RoundedCornerShape(8.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(56.dp),
                painter = painterResource(id = image),
                contentDescription = "",
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleLarge
                )
                Row {
                    IconAndTextComp(
                        icon = Icons.Default.SportsCricket,
                        text = matches
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    IconAndTextComp(
                        icon = Icons.Default.Star,
                        text = points
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    IconAndTextComp(
                        icon = Icons.Default.AcUnit,
                        text = rating
                    )
                }
            }
            Text(
                text = position.toString(),
                style = MaterialTheme.typography.displayMedium
            )
        }

    }
}