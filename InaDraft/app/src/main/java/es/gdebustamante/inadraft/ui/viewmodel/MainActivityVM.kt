package es.gdebustamante.inadraft.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.gdebustamante.inadraft.usescases.PopulateDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * ViewModel del dialog de elegir jugador
 * @property _isLoading LiveData observable para mostrar la Splash Screen hasta que se pueble la BBDD
 */
@HiltViewModel
class MainActivityVM @Inject constructor(
    private val populateDatabaseUseCase: PopulateDatabaseUseCase,
) : ViewModel() {

    //region live data

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    //endregion

    //region public methods

    init {
        viewModelScope.launch(Dispatchers.IO) {
            populateDatabaseUseCase.invoke()
            delay(500)
            _isLoading.value = false
        }
    }

    //endregion
}