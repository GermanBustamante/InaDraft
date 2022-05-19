package es.gdebustamante.inadraft.ui.view.bindingExtension

import androidx.core.view.isVisible
import es.gdebustamante.inadraft.databinding.FragmentPlayerInfoListBinding
import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.domain.PositionBO
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.ui.adapter.PlayerDetailAdapter
import es.gdebustamante.inadraft.ui.view.vo.toPlayerWithShieldVO
import es.gdebustamante.inadraft.ui.viewmodel.PlayerInfoListFragmentVM
import es.gdebustamante.inadraft.ui.viewmodel.TeamInfoListVM

private lateinit var teamSelected: TeamBO
private lateinit var playerList: List<PlayerBO>

fun FragmentPlayerInfoListBinding.setupRecyclerView(adapter: PlayerDetailAdapter) {
    playerInfoListFragmentSlideListOfPlayers.adapter = adapter
}

fun FragmentPlayerInfoListBinding.onPlayerListChanged(
    players: List<PlayerBO>,
) {
    playerList = players
}

fun FragmentPlayerInfoListBinding.onTeamSelectedChanged(
    team: TeamBO,
) {
    teamSelected = team
    playerInfoListFragmentToolbarTop.title = team.name
}

fun FragmentPlayerInfoListBinding.onPlayerPositionSelectedChanged(
    positions: List<PositionBO>,
    adapter: PlayerDetailAdapter
) {
    val playerListVO = playerList.map { player ->
        player.toPlayerWithShieldVO(
            teamSelected,
            positions.first { it.id == player.positionId })
    }
    playerInfoListFragmentSwipeRefreshLayout.isRefreshing = false
    adapter.submitList(playerListVO)
}

fun FragmentPlayerInfoListBinding.setupListeners(viewModel: TeamInfoListVM, teamId : Int) {
    playerInfoListFragmentSwipeRefreshLayout.setOnRefreshListener { onPlayerInfoListRefreshed(viewModel, teamId) }
}

fun onPlayerInfoListRefreshed(viewModel: TeamInfoListVM, teamId: Int) {
viewModel.loadPlayersWithShieldAndPosition(teamId)
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

