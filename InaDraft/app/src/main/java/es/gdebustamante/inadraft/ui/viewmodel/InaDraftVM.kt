package es.gdebustamante.inadraft.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.usescases.GetTeamListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InaDraftVM @Inject constructor(private val getTeamListUseCase: GetTeamListUseCase) : ViewModel() {

    val teamList: MutableLiveData<List<TeamBO>> =
        MutableLiveData() // TODO VER VIDEO LIVETEMPLATES ANDROID DEV CON GET MINUTO 43
    val progressVisible: MutableLiveData<Boolean> = MutableLiveData()

    fun onTeamClicked(teamSelected: TeamBO) {

    }

    fun loadTeamList() {
        viewModelScope.launch(Dispatchers.IO) {
            progressVisible.postValue(true)
            teamList.postValue(getTeamListUseCase.invoke()) // TODO VER SI PUEDO MEJORAR ESTO
            progressVisible.postValue(false)
        }
    }
}