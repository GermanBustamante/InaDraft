package es.gdebustamante.inadraft.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.gdebustamante.inadraft.data.entities.bo.TeamBO
import es.gdebustamante.inadraft.domain.GetAPITeamsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InaDraftVM : ViewModel(){

    val teamList : MutableLiveData<List<TeamBO>> = MutableLiveData()

    fun getTeamsList(){
        viewModelScope.launch(Dispatchers.IO) {
            val teamListFromAPI = GetAPITeamsUseCase().invoke() // TODO VER SI PUEDO MEJORAR ESTO
            teamList.postValue(teamListFromAPI)
        }
    }
}