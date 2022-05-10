package es.gdebustamante.inadraft.ui.view.bindingExtension


import androidx.core.view.isVisible
import es.gdebustamante.inadraft.databinding.FragmentTeamListBinding
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.ui.adapter.TeamAdapter
import es.gdebustamante.inadraft.ui.viewmodel.InaDraftVM

fun FragmentTeamListBinding.setupRecyclerView(adapter: TeamAdapter) {
    teamListFragmentSlideListOfTeams.adapter = adapter
}

fun FragmentTeamListBinding.onTeamClicked(teamSelected: TeamBO) {
//    root.findNavController().navigate(R)
}

fun FragmentTeamListBinding.onProgressVisibleChanged(visibility: Boolean) {
    teamListFragmentSlideProgressIndicatorTeamList.isVisible = visibility
}

fun FragmentTeamListBinding.onTeamListChanged(
    teamList: List<TeamBO>?,
    adapter: TeamAdapter
) { adapter.submitList(teamList) }
