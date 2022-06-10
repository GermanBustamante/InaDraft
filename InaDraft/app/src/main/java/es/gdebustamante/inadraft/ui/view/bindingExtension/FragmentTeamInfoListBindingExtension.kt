package es.gdebustamante.inadraft.ui.view.bindingExtension

import androidx.core.view.isVisible
import androidx.navigation.findNavController
import es.gdebustamante.inadraft.databinding.FragmentTeamInfoListBinding
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.ui.adapter.TeamAdapter
import es.gdebustamante.inadraft.ui.view.fragment.TeamInfoListFragmentDirections
import es.gdebustamante.inadraft.ui.viewmodel.TeamInfoListVM

//region public methods

/**
 * Linkea un RecyclerView con el adaptador pasado por parámetro
 */
fun FragmentTeamInfoListBinding.setupRecyclerView(adapter: TeamAdapter) {
    infoTeamFragmentListOfTeams.adapter = adapter
}

/**
 * Dado un equipo clickado, navega a una pantalla de listado de jugadores de dicho equipo
 */
fun FragmentTeamInfoListBinding.onTeamClicked(teamSelected: TeamBO) {
    root.findNavController().navigate(
        TeamInfoListFragmentDirections.actionInfoTeamFragmentToPlayerListFragment(teamSelected.id)
    )
}

/**
 * Prepara los listeners asociados con [FragmentTeamInfoListBinding]
 */
fun FragmentTeamInfoListBinding.setupListeners(viewModel : TeamInfoListVM){
    infoTeamFragmentSwipeRefreshLayout.setOnRefreshListener { onTeamInfoListRefreshed(viewModel) }
}

/**
 * Dado un listado de equipos, setea a invisible la barra de cargando y actualiza la lista
 */
fun FragmentTeamInfoListBinding.onTeamListChanged(
    teamList: List<TeamBO>,
    adapter: TeamAdapter
) {
    infoTeamFragmentSwipeRefreshLayout.isRefreshing = false
    adapter.submitList(teamList)
}

/**
 * Setea las visibilidades de una pantalla de "Cargando" y otra con el listado ya cargado en función del parámetro [visibility]
 */
fun FragmentTeamInfoListBinding.onProgressVisibleChanged(visibility: Boolean) {
    if (visibility){
        teamInfoListFragmentLoading.root.startShimmer()
    }else{
        teamInfoListFragmentLoading.root.stopShimmer()
    }
    teamInfoListFragmentLoading.root.isVisible = visibility
    infoTeamFragmentListOfTeams.isVisible = !visibility
}

//endregion

//region private methods

private fun FragmentTeamInfoListBinding.onTeamInfoListRefreshed(viewModel : TeamInfoListVM) {
    viewModel.loadTeamList()
}

//endregion
