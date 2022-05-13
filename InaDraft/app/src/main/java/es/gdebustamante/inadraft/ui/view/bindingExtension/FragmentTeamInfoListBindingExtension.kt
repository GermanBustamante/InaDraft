package es.gdebustamante.inadraft.ui.view.bindingExtension

import androidx.core.view.isVisible
import androidx.navigation.findNavController
import es.gdebustamante.inadraft.databinding.FragmentTeamInfoListBinding
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.ui.adapter.TeamAdapter
import es.gdebustamante.inadraft.ui.view.fragment.TeamInfoListFragmentDirections

fun FragmentTeamInfoListBinding.setupRecyclerView(adapter: TeamAdapter) {
    infoTeamFragmentListOfTeams.adapter = adapter
}

fun FragmentTeamInfoListBinding.onTeamClicked(teamSelected: TeamBO) {
    root.findNavController().navigate(
        TeamInfoListFragmentDirections.actionInfoTeamFragmentToPlayerListFragment(teamSelected.id)
    )
}

fun FragmentTeamInfoListBinding.onProgressVisibleChanged(visibility: Boolean) {
    infoTeamFragmentListOfTeams.isVisible = visibility
}

fun FragmentTeamInfoListBinding.onTeamListChanged(
    teamList: List<TeamBO>,
    adapter: TeamAdapter
) {
    adapter.submitList(teamList) //TODO COMPROBAR SI ES VACIO MOSTRAR MENSAJE CORRESPONDIENTE, O TIPO DE ERROR CUANDO VEA KBP
}
