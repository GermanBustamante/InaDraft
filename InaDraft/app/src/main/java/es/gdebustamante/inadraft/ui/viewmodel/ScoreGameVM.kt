package es.gdebustamante.inadraft.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.gdebustamante.inadraft.domain.GameBO
import es.gdebustamante.inadraft.usescases.GetGamesUseCase
import es.gdebustamante.inadraft.usescases.InsertFinishedGameUseCase
import es.gdebustamante.inadraft.usescases.InsertGamesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScoreGameVM @Inject constructor(
    private val insertFinishedGameUseCase: InsertFinishedGameUseCase
): ViewModel() {

    //region livedata
    private val _operationSuccess = MutableLiveData<Boolean>()
    val operationSuccess: LiveData<Boolean> get() = _operationSuccess
    //endregion

    //region public metods
    fun insertGame(game : GameBO) {
        viewModelScope.launch(Dispatchers.IO) {
            _operationSuccess.postValue(insertFinishedGameUseCase.invoke(game))
        }
    }
    //endregion

}