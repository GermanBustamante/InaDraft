package es.gdebustamante.inadraft.ui.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.gdebustamante.inadraft.usescases.GetPlayerListByTeamUseCase
import es.gdebustamante.inadraft.usescases.GetPositionListUseCase
import es.gdebustamante.inadraft.usescases.GetTeamByIdUseCase
import es.gdebustamante.inadraft.usescases.GetTeamListUseCase
import javax.inject.Inject

@HiltViewModel
class GameVM @Inject constructor(
) : ViewModel(){}