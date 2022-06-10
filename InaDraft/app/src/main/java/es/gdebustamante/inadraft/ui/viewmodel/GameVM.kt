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


/**
 * ViewModel del fragment de la pantalla de inicio
 * @property _playersDraft LiveData observable con el listado de jugadores mapeado con el id de su carta correspondiente
 */
@HiltViewModel
class GameVM @Inject constructor(
    private val getPlayerByIdUseCase: GetPlayerByIdUseCase
) : ViewModel(){

    //region livedata

    private val _playersDraft : MutableLiveData<MutableMap<Int,PlayerBO>> = MutableLiveData(mutableMapOf())
    val playersDraft: LiveData<MutableMap<Int,PlayerBO>> get() = _playersDraft
    //endregion

    //region public methods

    fun loadPlayer(playerCardId: Int, playerId: Int){
        viewModelScope.launch(Dispatchers.IO) {
            val playersMapDraft = _playersDraft.value
            playersMapDraft?.put(playerCardId, getPlayerByIdUseCase.invoke(playerId))
            _playersDraft.postValue(playersMapDraft ?: mutableMapOf())
        }
    }

    //endregion
}