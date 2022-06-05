package es.gdebustamante.inadraft.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.gdebustamante.inadraft.domain.GameBO
import es.gdebustamante.inadraft.usescases.GetBestGamesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RankingVM @Inject constructor(
    private val getBestGamesUseCase: GetBestGamesUseCase,
) : ViewModel() {

    //region live data

    private val _games = MutableLiveData<List<GameBO>>()
    val games: LiveData<List<GameBO>> get() = _games

    //endregion

    //region public functions

    fun loadBestGames(){
        viewModelScope.launch (Dispatchers.IO){
            _games.postValue(getBestGamesUseCase.invoke())
        }
    }

    //endregion
}
