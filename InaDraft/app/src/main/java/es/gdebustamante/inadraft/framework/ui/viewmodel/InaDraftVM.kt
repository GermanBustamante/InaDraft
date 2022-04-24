package es.gdebustamante.inadraft.framework.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.usescases.LoadTeamsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InaDraftVM @Inject constructor(private val loadTeamListUseCase: LoadTeamsUseCase) : ViewModel() {

    val teamList: MutableLiveData<List<TeamBO>> =
        MutableLiveData() // TODO VER VIDEO LIVETEMPLATES ANDROID DEV CON GET MINUTO 43
    val progressVisible: MutableLiveData<Boolean> = MutableLiveData()

    fun onTeamClicked(teamSelected: TeamBO) {
        // TODO CAMBIAR FRAGMENT AL DE JUGADORES
    }

    fun loadTeamList() {
        viewModelScope.launch(Dispatchers.Main) {
            progressVisible.value = true
            teamList.postValue(loadTeamListUseCase.invoke()) // TODO VER SI PUEDO MEJORAR ESTO
            progressVisible.value = false
        }
    }
}