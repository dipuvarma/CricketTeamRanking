package com.example.cricketteamranking.team_ranking.data.mappers

import com.example.cricketteamranking.team_ranking.data.dto.team_ranking_dto.TeamRankingDTO
import com.example.cricketteamranking.team_ranking.domain.model.TeamRankingUI


fun TeamRankingDTO.toTeamRankingUI(): List<TeamRankingUI> {
    return data.flatMap { dataItem ->
        dataItem.team.map { teamItem ->
            TeamRankingUI(
                id = teamItem.id,
                type = dataItem.type,
                gender = dataItem.gender,
                updateAt = dataItem.updated_at,
                code = teamItem.code,
                name = teamItem.name,
                image_path = teamItem.image_path,
                ranking = teamItem.ranking
            )
        }
    }
}