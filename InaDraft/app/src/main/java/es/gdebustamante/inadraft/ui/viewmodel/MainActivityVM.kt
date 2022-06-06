package es.gdebustamante.inadraft.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.gdebustamante.inadraft.usescases.PopulateDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityVM @Inject constructor(
    private val populateDatabaseUseCase: PopulateDatabaseUseCase,
) : ViewModel() {

    //region live data

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(true)
    val isLoading: LiveData<Boolean> get() = _isLoading

    //endregion

    //region public methods

    init {
        viewModelScope.launch(Dispatchers.IO) {
            populateDatabaseUseCase.invoke()
            _isLoading.postValue(false)
        }
    }

    //endregion
}