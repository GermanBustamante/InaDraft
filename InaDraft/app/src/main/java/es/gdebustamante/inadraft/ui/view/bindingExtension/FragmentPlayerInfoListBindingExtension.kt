package es.gdebustamante.inadraft.ui.view.bindingExtension

import androidx.core.view.isVisible
import es.gdebustamante.inadraft.databinding.FragmentPlayerInfoListBinding
import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.ui.adapter.PlayerDetailAdapter
import es.gdebustamante.inadraft.ui.viewmodel.PlayerInfoListVM

//region public methods
/**
 * Linkea un RecyclerView de jugadores con el adapter pasado por parametro
 */
fun FragmentPlayerInfoListBinding.setupRecyclerView(adapter: PlayerDetailAdapter) {
    playerInfoListFragmentSlideListOfPlayers.adapter = adapter
}

/**
 * Dado un listado de jugadores y un adaptador, setea a invisible la pantalla de loading y actualiza dicha lista
 */
fun FragmentPlayerInfoListBinding.onPlayerListChanged(
    players: List<PlayerBO>,
    adapter: PlayerDetailAdapter,
) {
    playerInfoListFragmentSwipeRefreshLayout.isRefreshing = false
    adapter.submitList(players)
}

/**
 * Prepara los listeners asociados a [FragmentPlayerInfoListBinding]
 */
fun FragmentPlayerInfoListBinding.setupListeners(viewModel: PlayerInfoListVM, teamId : Int) {
    playerInfoListFragmentSwipeRefreshLayout.setOnRefreshListener { onPlayerInfoListRefreshed(viewModel, teamId) }
}

/**
 * Llamada a [viewModel.loadPlayerByTeam] para pedir a este un listado de jugadores por un equipo
 */
fun onPlayerInfoListRefreshed(viewModel: PlayerInfoListVM, teamId: Int) {
    viewModel.loadPlayerByTeam(teamId)
}

/**
 * Setea las visibilidades de una pantalla de "Cargando" y otra con el listado ya cargado en función del parámetro [visibility]
 */
fun FragmentPlayerInfoListBinding.onProgressVisibleChanged(visibility: Boolean) {
    if (visibility){
        playerInfoListFragmentLoading.root.startShimmer()
    }else{
        playerInfoListFragmentLoading.root.stopShimmer()
    }
    playerInfoListFragmentLoading.root.isVisible = visibility
    playerInfoListFragmentSlideListOfPlayers.isVisible = !visibility
}

//endregion

