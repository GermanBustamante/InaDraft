package es.gdebustamante.inadraft.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.domain.PositionBO
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.usescases.GetTeamsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamInfoListVM @Inject constructor(
    private val getTeamsUseCase: GetTeamsUseCase,

    ) : ViewModel() {

    //region live data

    private val _teamList = MutableLiveData<List<TeamBO>>()
    val teamList: LiveData<List<TeamBO>> get() = _teamList

    private val _progressVisible = MutableLiveData<Boolean>()
    val progressVisible: LiveData<Boolean> get() = _progressVisible

    //endregion

    //region public functions

    fun loadTeamList() {
        viewModelScope.launch(Dispatchers.IO) {
            _progressVisible.postValue(true)
            _teamList.postValue(getTeamsUseCase.invoke())
            _progressVisible.postValue(false)
        }
    }

    //endregion


}