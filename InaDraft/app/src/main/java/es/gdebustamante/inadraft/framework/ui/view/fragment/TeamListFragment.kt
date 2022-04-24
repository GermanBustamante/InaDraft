package es.gdebustamante.inadraft.framework.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import es.gdebustamante.inadraft.databinding.FragmentTeamListBinding
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.framework.ui.adapter.TeamAdapter
import es.gdebustamante.inadraft.framework.ui.view.base.BaseFragment
import es.gdebustamante.inadraft.framework.ui.view.bindingExtension.onTeamClicked
import es.gdebustamante.inadraft.framework.ui.view.bindingExtension.setupRecyclerView
import es.gdebustamante.inadraft.framework.ui.view.bindingExtension.setupVMObservers
import es.gdebustamante.inadraft.framework.ui.viewmodel.InaDraftVM

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
        binding?.setupVMObservers(viewModel, adapter)
        viewModel.loadTeamList()
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTeamListBinding = FragmentTeamListBinding.inflate(inflater, container, false)
}
