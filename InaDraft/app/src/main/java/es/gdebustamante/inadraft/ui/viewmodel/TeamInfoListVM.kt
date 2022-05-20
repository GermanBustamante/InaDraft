package es.gdebustamante.inadraft.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.domain.PositionBO
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.usescases.GetPlayersByTeamUseCase
import es.gdebustamante.inadraft.usescases.GetPositionsUseCase
import es.gdebustamante.inadraft.usescases.GetTeamByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamInfoListVM @Inject constructor(
    private val getPlayersByTeamUseCase: GetPlayersByTeamUseCase,
    private val getTeamByIdUseCase: GetTeamByIdUseCase,
    private val getPositionsUseCase: GetPositionsUseCase
) : ViewModel() {

    private val _playerList = MutableLiveData<List<PlayerBO>>()
    val playerList: LiveData<List<PlayerBO>> get() = _playerList

    private val _teamSelected = MutableLiveData<TeamBO>()
    val teamSelected: LiveData<TeamBO> get() = _teamSelected

    private val _positionList = MutableLiveData<List<PositionBO>>()
    val positionList: LiveData<List<PositionBO>> get() = _positionList

    private val _progressVisible = MutableLiveData<Boolean>()
    val progressVisible: LiveData<Boolean> get() = _progressVisible

    fun loadPlayersWithShieldAndPosition(teamId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _progressVisible.postValue(true)
            loadPlayerListByTeamId(teamId)
            loadTeamById(teamId)
            loadPositionsById()
            _progressVisible.postValue(false)
        }
    }

    private suspend fun loadPlayerListByTeamId(teamId: Int) {
        _playerList.postValue(getPlayersByTeamUseCase.invoke(teamId))
    }

    private suspend fun loadTeamById(teamId: Int) {
        _teamSelected.postValue(getTeamByIdUseCase.invoke(teamId))
    }

    private suspend fun loadPositionsById() {
        _positionList.postValue(getPositionsUseCase.invoke())
    }
}