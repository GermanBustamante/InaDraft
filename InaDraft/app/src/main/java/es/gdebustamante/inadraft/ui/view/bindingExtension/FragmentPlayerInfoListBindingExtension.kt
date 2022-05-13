package es.gdebustamante.inadraft.ui.view.bindingExtension

import es.gdebustamante.inadraft.databinding.FragmentPlayerInfoListBinding
import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.domain.PositionBO
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.ui.adapter.PlayerDetailAdapter
import es.gdebustamante.inadraft.ui.view.vo.toPlayerWithShieldVO
import es.gdebustamante.inadraft.ui.viewmodel.InaDraftVM

private lateinit var teamSelected: TeamBO
private lateinit var playerList: List<PlayerBO>

fun FragmentPlayerInfoListBinding.setupRecyclerView(adapter: PlayerDetailAdapter) {
    playerInfoListFragmentSlideListOfPlayers.adapter = adapter
}

fun FragmentPlayerInfoListBinding.onPlayerListChanged(
    players: List<PlayerBO>,
    viewModel: InaDraftVM
) {
    playerList = players
    viewModel.loadPositionsById()
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
    adapter.submitList(playerListVO)
}