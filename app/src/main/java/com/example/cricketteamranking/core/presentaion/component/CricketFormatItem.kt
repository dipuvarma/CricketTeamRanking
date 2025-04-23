package com.example.cricketteamranking.core.presentaion.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cricketteamranking.team_ranking.domain.model.CricketFormat


@Composable
fun CricketFormatItem(
    format: CricketFormat,
    onClickItem: () -> Unit,
) {

    val mainColor = if (format.gender == "men") Color.Blue else Color.Magenta
    val menOrWomenIcon = if (format.gender == "men") Icons.Default.Male else Icons.Default.Female

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RectangleShape)
            .background(color = mainColor)
            .clickable { onClickItem() }
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = format.type,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = menOrWomenIcon,
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = if (format.gender == "men") "Men" else "Women")
            }
        }
    }
}