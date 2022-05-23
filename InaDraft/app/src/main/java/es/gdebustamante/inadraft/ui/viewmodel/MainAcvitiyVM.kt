package es.gdebustamante.inadraft.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.usescases.PopulateDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainAcvitiyVM @Inject constructor(
    private val populateDatabaseUseCase: PopulateDatabaseUseCase
) : ViewModel() {

    //region live data

    private val _playerListHome = MutableLiveData<List<PlayerBO>>()
    val playerListHome: LiveData<List<PlayerBO>> get() = _playerListHome

    //endregion

    //region funciones publicas

    fun init() {
        viewModelScope.launch(Dispatchers.IO) {

            populateDatabaseUseCase.invoke()

        }
    }

    //endregion
}