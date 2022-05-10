package es.gdebustamante.inadraft.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import es.gdebustamante.inadraft.databinding.FragmentTeamListBinding
import es.gdebustamante.inadraft.ui.adapter.TeamAdapter
import es.gdebustamante.inadraft.ui.view.base.BaseFragment
import es.gdebustamante.inadraft.ui.view.bindingExtension.*
import es.gdebustamante.inadraft.ui.viewmodel.InaDraftVM

@AndroidEntryPoint
class TeamListFragment :
    BaseFragment<FragmentTeamListBinding>() {

    private val viewModel: InaDraftVM by activityViewModels()
    private val adapter = TeamAdapter { binding?.onTeamClicked(it) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateViewBinding(inflater, container)
        binding?.setupRecyclerView(adapter)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.teamList.observe(viewLifecycleOwner) { teamList -> binding?.onTeamListChanged(teamList, adapter) }
        viewModel.progressVisible.observe(viewLifecycleOwner) { binding?.onProgressVisibleChanged(it) }
        viewModel.loadTeamList()
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTeamListBinding = FragmentTeamListBinding.inflate(inflater, container, false)
}
