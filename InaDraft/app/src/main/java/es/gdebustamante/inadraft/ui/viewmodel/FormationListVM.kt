package es.gdebustamante.inadraft.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.gdebustamante.inadraft.domain.FormationBO
import es.gdebustamante.inadraft.usescases.GetFormationsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FormationListVM @Inject constructor(
    private val getFormationsUseCase: GetFormationsUseCase
) : ViewModel(){

    //region livedata

    private val _formations = MutableLiveData<List<FormationBO>>()
    val formations: LiveData<List<FormationBO>> get() = _formations

    //endregion

    //region public functions

    fun loadFormations() {
       viewModelScope.launch(Dispatchers.IO) {
           _formations.postValue(getFormationsUseCase.invoke())
       }
    }

    //endregion
}