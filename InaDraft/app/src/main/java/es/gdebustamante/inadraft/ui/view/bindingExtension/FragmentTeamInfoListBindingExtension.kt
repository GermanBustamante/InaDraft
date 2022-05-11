package es.gdebustamante.inadraft.ui.view.bindingExtension

import androidx.core.view.isVisible
import androidx.navigation.findNavController
import es.gdebustamante.inadraft.databinding.FragmentTeamInfoListBinding
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.ui.adapter.TeamAdapter
import es.gdebustamante.inadraft.ui.view.fragment.TeamInfoListFragmentDirections

fun FragmentTeamInfoListBinding.setupRecyclerView(adapter: TeamAdapter) {
    teamListFragmentSlideListOfTeams.adapter = adapter
}

fun FragmentTeamInfoListBinding.onTeamClicked(teamSelected: TeamBO) {
    root.findNavController().navigate(TeamInfoListFragmentDirections.actionInfoTeamFragment2ToPlayerListFragment(teamSelected.id, teamSelected.shield))
}

fun FragmentTeamInfoListBinding.onProgressVisibleChanged(visibility: Boolean) {
    teamListFragmentSlideProgressIndicatorTeamList.isVisible = visibility
}

fun FragmentTeamInfoListBinding.onTeamListChanged(
    teamList: List<TeamBO>?,
    adapter: TeamAdapter
) { adapter.submitList(teamList) }
