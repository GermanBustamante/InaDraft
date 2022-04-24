package es.gdebustamante.inadraft.framework.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import es.gdebustamante.inadraft.databinding.FragmentTeamListBinding
import es.gdebustamante.inadraft.domain.entities.TeamBO
import es.gdebustamante.inadraft.framework.ui.adapter.TeamAdapter
import es.gdebustamante.inadraft.framework.ui.view.base.BaseFragment
import es.gdebustamante.inadraft.framework.ui.viewmodel.InaDraftVM

@AndroidEntryPoint
class TeamListFragment :
    BaseFragment<FragmentTeamListBinding>() { // TODO PASAR A FICHERO DE EXTENSION

    private val viewModel: InaDraftVM by activityViewModels()
    private val adapter = TeamAdapter { viewModel.onTeamClicked(it) }

    companion object {
        @JvmStatic
        fun newInstance() = TeamListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateViewBinding(inflater, container)
        binding?.teamListFragmentSlideListOfTeams?.adapter = adapter
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupVMObservers()
        viewModel.loadTeamList()
    }

    private fun setupVMObservers() {
        viewModel.teamList.observe(viewLifecycleOwner, this::onTeamListChanged)
        viewModel.progressVisible.observe(viewLifecycleOwner, this::onProgressVisibleChanged)
    }

    private fun onProgressVisibleChanged(visible: Boolean) {
        binding?.teamListFragmentSlideProgressIndicatorTeamList?.isVisible = visible
    }

    private fun onTeamListChanged(teamList: List<TeamBO>) {
        adapter.submitList(teamList)
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTeamListBinding = FragmentTeamListBinding.inflate(inflater, container, false)
}