package es.gdebustamante.inadraft.ui.view.bindingExtension

import androidx.core.view.isVisible
import androidx.navigation.findNavController
import es.gdebustamante.inadraft.databinding.FragmentTeamInfoListBinding
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.ui.adapter.TeamAdapter
import es.gdebustamante.inadraft.ui.view.fragment.TeamInfoListFragmentDirections
import es.gdebustamante.inadraft.ui.viewmodel.TeamInfoListVM

fun FragmentTeamInfoListBinding.setupRecyclerView(adapter: TeamAdapter) {
    infoTeamFragmentListOfTeams.adapter = adapter
}

fun FragmentTeamInfoListBinding.onTeamClicked(teamSelected: TeamBO) {
    root.findNavController().navigate(
        TeamInfoListFragmentDirections.actionInfoTeamFragmentToPlayerListFragment(teamSelected.id)
    )
}

fun FragmentTeamInfoListBinding.setupListeners(viewModel : TeamInfoListVM){
    infoTeamFragmentSwipeRefreshLayout.setOnRefreshListener { onTeamInfoListRefreshed(viewModel) }
}

fun FragmentTeamInfoListBinding.onTeamListChanged(
    teamList: List<TeamBO>,
    adapter: TeamAdapter
) {
    infoTeamFragmentSwipeRefreshLayout.isRefreshing = false
    adapter.submitList(teamList) //TODO COMPROBAR SI ES VACIO MOSTRAR MENSAJE CORRESPONDIENTE, O TIPO DE ERROR CUANDO VEA KBP

}

fun FragmentTeamInfoListBinding.onProgressVisibleChanged(visibility: Boolean) {
    if (visibility){
        teamInfoListFragmentLoading.root.startShimmer()
    }else{
        teamInfoListFragmentLoading.root.stopShimmer()
    }
    teamInfoListFragmentLoading.root.isVisible = visibility
    infoTeamFragmentListOfTeams.isVisible = !visibility
}

private fun FragmentTeamInfoListBinding.onTeamInfoListRefreshed(viewModel : TeamInfoListVM) {
    viewModel.loadTeamList()
}
