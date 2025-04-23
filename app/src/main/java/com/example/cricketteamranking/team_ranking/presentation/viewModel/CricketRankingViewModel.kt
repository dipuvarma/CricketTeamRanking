package com.example.cricketteamranking.team_ranking.presentation.viewModel

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cricketteamranking.team_ranking.data.repository.TeamRankingRepositoryImpl
import com.example.cricketteamranking.team_ranking.domain.model.TeamRankingUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CricketRankingViewModel : ViewModel() {

    val cricketRepo: TeamRankingRepositoryImpl = TeamRankingRepositoryImpl()

    private val _state = MutableStateFlow(CricketStateUI())
    val state = _state.asStateFlow()


    fun event(event: OnEvent) {
        when (event) {
            is OnEvent.GetTeamRanking -> {
                getTeamRanking(event.type, event.gender)
            }
        }
    }

    fun getTeamRanking(type: String, gender: String) {
        viewModelScope.launch {
            cricketRepo.getTeamRankingByTypeAndGender(type, gender).collect {
                _state.value = state.value.copy(
                    isLoading = true,
                    data = it,
                )
                _state.value = state.value.copy(
                    isLoading = false,
                )
            }
        }
    }
}


data class CricketStateUI(
    val isLoading: Boolean = false,
    val data: List<TeamRankingUI> = emptyList(),
)


sealed class OnEvent {
    data class GetTeamRanking(val type: String, val gender: String) : OnEvent()
}