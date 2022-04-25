package es.gdebustamante.inadraft.framework.ui.view.bindingExtension

import androidx.core.view.isVisible
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.navigation.findNavController
import es.gdebustamante.inadraft.databinding.FragmentTeamListBinding
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.framework.ui.adapter.TeamAdapter
import es.gdebustamante.inadraft.framework.ui.viewmodel.InaDraftVM

fun FragmentTeamListBinding.setupRecyclerView(adapter: TeamAdapter) {
    teamListFragmentSlideListOfTeams.adapter = adapter
}

fun FragmentTeamListBinding.setupVMObservers(viewModel: InaDraftVM, adapter: TeamAdapter) {
    root.apply {
        findViewTreeLifecycleOwner()?.let { lifecycleOwner ->
            viewModel.teamList.observe(lifecycleOwner) { teamList -> onTeamListChanged(teamList, adapter) }
            findViewTreeLifecycleOwner()?.let {
                viewModel.progressVisible.observe(it,this@setupVMObservers::onProgressVisibleChanged)}
        }
    }
}

fun FragmentTeamListBinding.onTeamClicked(teamSelected: TeamBO) {
//    root.findNavController().navigate(R)
}

private fun FragmentTeamListBinding.onProgressVisibleChanged(visibility: Boolean) {
    teamListFragmentSlideProgressIndicatorTeamList.isVisible = visibility
}

private fun FragmentTeamListBinding.onTeamListChanged(
    teamList: List<TeamBO>?,
    adapter: TeamAdapter
) { adapter.submitList(teamList) }
