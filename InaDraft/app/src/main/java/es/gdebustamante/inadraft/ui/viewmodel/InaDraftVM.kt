package es.gdebustamante.inadraft.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.usescases.GetPlayerListByTeamUseCase
import es.gdebustamante.inadraft.usescases.GetTeamListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InaDraftVM @Inject constructor(
    private val getTeamListUseCase: GetTeamListUseCase,
    private val getPlayerListByTeamUseCase: GetPlayerListByTeamUseCase
) : ViewModel() {

    private val _teamList = MutableLiveData<List<TeamBO>>()
    val teamList: LiveData<List<TeamBO>> get() = _teamList

    private val _playerList = MutableLiveData<List<PlayerBO>>()
    val playerSelected: LiveData<List<PlayerBO>> get() = _playerList

    val progressVisible: MutableLiveData<Boolean> = MutableLiveData()

    fun loadTeamList() {
        viewModelScope.launch(Dispatchers.IO) {
            progressVisible.postValue(true)
            _teamList.postValue(getTeamListUseCase.invoke()) // TODO VER SI PUEDO MEJORAR ESTO
            progressVisible.postValue(false)
        }
    }

    fun loadPlayerListByTeamId(teamId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _playerList.postValue(getPlayerListByTeamUseCase.invoke(teamId))
        }
    }
}