package es.gdebustamante.inadraft.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.gdebustamante.inadraft.domain.FormationBO
import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.usescases.GetFormationsUseCase
import es.gdebustamante.inadraft.usescases.GetRandomPlayersByPositionUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel del dialog de elegir jugador
 * @property _randomPlayers LiveData observable con el listado de jugadores aleatorios a mostrar
 */
@HiltViewModel
class ChoosePlayerVM @Inject constructor(
    private val getRandomPlayersByPositionUseCase: GetRandomPlayersByPositionUseCase
) : ViewModel(){

    //region livedata

    private val _randomPlayers = MutableLiveData<List<PlayerBO>>()
    val randomPlayers: LiveData<List<PlayerBO>> get() = _randomPlayers

    //endregion

    //region public functions

    fun loadRandomPlayers(positionId : Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _randomPlayers.postValue(getRandomPlayersByPositionUseCase.invoke(positionId))
        }
    }

    //endregion

}