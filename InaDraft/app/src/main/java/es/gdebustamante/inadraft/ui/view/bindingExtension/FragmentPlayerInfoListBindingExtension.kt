package es.gdebustamante.inadraft.ui.view.bindingExtension

import androidx.core.view.isVisible
import es.gdebustamante.inadraft.databinding.FragmentPlayerInfoListBinding
import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.domain.PositionBO
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.ui.adapter.PlayerDetailAdapter
import es.gdebustamante.inadraft.ui.view.vo.toPlayerWithShieldVO
import es.gdebustamante.inadraft.ui.viewmodel.PlayerInfoListVM

fun FragmentPlayerInfoListBinding.setupRecyclerView(adapter: PlayerDetailAdapter) {
    playerInfoListFragmentSlideListOfPlayers.adapter = adapter
}

fun FragmentPlayerInfoListBinding.onPlayerListChanged(
    players: List<PlayerBO>,
    adapter: PlayerDetailAdapter,
) {
    playerInfoListFragmentSwipeRefreshLayout.isRefreshing = false
    adapter.submitList(players)
}

fun FragmentPlayerInfoListBinding.setupListeners(viewModel: PlayerInfoListVM, teamId : Int) {
    playerInfoListFragmentSwipeRefreshLayout.setOnRefreshListener { onPlayerInfoListRefreshed(viewModel, teamId) }
}

fun onPlayerInfoListRefreshed(viewModel: PlayerInfoListVM, teamId: Int) {
viewModel.loadPlayerByTeam(teamId)
}

fun FragmentPlayerInfoListBinding.onProgressVisibleChanged(visibility: Boolean) {
    if (visibility){
        playerInfoListFragmentLoading.root.startShimmer()
    }else{
        playerInfoListFragmentLoading.root.stopShimmer()
    }
    playerInfoListFragmentLoading.root.isVisible = visibility
    playerInfoListFragmentSlideListOfPlayers.isVisible = !visibility
}

