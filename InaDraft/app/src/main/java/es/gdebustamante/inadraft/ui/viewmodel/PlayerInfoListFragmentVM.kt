package es.gdebustamante.inadraft.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.domain.PositionBO
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.usescases.GetPlayerListByTeamUseCase
import es.gdebustamante.inadraft.usescases.GetPositionListUseCase
import es.gdebustamante.inadraft.usescases.GetTeamByIdUseCase
import es.gdebustamante.inadraft.usescases.GetTeamListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerInfoListFragmentVM @Inject constructor(
    private val getTeamListUseCase: GetTeamListUseCase,

) : ViewModel() {

    private val _teamList = MutableLiveData<List<TeamBO>>()
    val teamList: LiveData<List<TeamBO>> get() = _teamList

    private val _playerList = MutableLiveData<List<PlayerBO>>()
    val playerList: LiveData<List<PlayerBO>> get() = _playerList

    private val _teamSelected = MutableLiveData<TeamBO>()
    val teamSelected: LiveData<TeamBO> get() = _teamSelected

    private val _positionList = MutableLiveData<List<PositionBO>>()
    val positionList: LiveData<List<PositionBO>> get() = _positionList

    private val _progressVisible = MutableLiveData<Boolean>()
    val progressVisible: LiveData<Boolean> get() = _progressVisible

    fun loadTeamList() {
        viewModelScope.launch(Dispatchers.Main) {
            _progressVisible.value = true
            _teamList.value = getTeamListUseCase.invoke() // TODO VER SI PUEDO MEJORAR ESTO
            _progressVisible.value = false
        }
    }


}