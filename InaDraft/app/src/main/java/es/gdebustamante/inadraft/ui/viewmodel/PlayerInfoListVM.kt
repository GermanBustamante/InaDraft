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
class PlayerInfoListVM @Inject constructor(
    private val getPlayersByTeamUseCase: GetPlayersByTeamUseCase,
) : ViewModel() {

    //region live data

    private val _playerList = MutableLiveData<List<PlayerBO>>()
    val playerList: LiveData<List<PlayerBO>> get() = _playerList

    private val _progressVisible = MutableLiveData<Boolean>()
    val progressVisible: LiveData<Boolean> get() = _progressVisible

    //endregion

    //region public methods

    fun loadPlayerByTeam(teamId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _progressVisible.postValue(true)
            _playerList.postValue(getPlayersByTeamUseCase.invoke(teamId))
            _progressVisible.postValue(false)
        }
    }

    //endregion
}