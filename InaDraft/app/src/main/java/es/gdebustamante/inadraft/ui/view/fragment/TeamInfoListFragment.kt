package es.gdebustamante.inadraft.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import es.gdebustamante.inadraft.databinding.FragmentTeamInfoListBinding
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.ui.adapter.TeamAdapter
import es.gdebustamante.inadraft.ui.view.base.BaseFragment
import es.gdebustamante.inadraft.ui.view.bindingExtension.onProgressVisibleChanged
import es.gdebustamante.inadraft.ui.view.bindingExtension.onTeamClicked
import es.gdebustamante.inadraft.ui.view.bindingExtension.onTeamListChanged
import es.gdebustamante.inadraft.ui.view.bindingExtension.setupRecyclerView
import es.gdebustamante.inadraft.ui.viewmodel.InaDraftVM

@AndroidEntryPoint
class TeamInfoListFragment : BaseFragment<FragmentTeamInfoListBinding>() {

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
        viewModel.teamList.observe(viewLifecycleOwner) { teamList ->
            binding?.onTeamListChanged(
                teamList,
                adapter
            )
        }
        viewModel.progressVisible.observe(viewLifecycleOwner) { binding?.onProgressVisibleChanged(it) }
        viewModel.loadTeamList()
//        adapter.submitList(listOf(TeamBO(1, "Chanos", "dasda")))
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTeamInfoListBinding = FragmentTeamInfoListBinding.inflate(inflater, container, false)
}
