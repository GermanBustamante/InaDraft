package es.gdebustamante.inadraft.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.usescases.GetPlayerByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameVM @Inject constructor(
    private val getPlayerByIdUseCase: GetPlayerByIdUseCase
) : ViewModel(){

    //region livedata

    private val _playersDraft : MutableLiveData<MutableList<PlayerBO>> = MutableLiveData(mutableListOf())
    val playersDraft: LiveData<MutableList<PlayerBO>> get() = _playersDraft
    //endregion

    //region public methods

    fun loadPlayer(playerId : Int){
        viewModelScope.launch(Dispatchers.IO) {
            val playersListDraft = _playersDraft.value
            playersListDraft?.add(getPlayerByIdUseCase.invoke(playerId))
            _playersDraft.postValue(playersListDraft ?: mutableListOf())
        }
    }

    //endregion
}