package es.gdebustamante.inadraft.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import es.gdebustamante.inadraft.databinding.FragmentTeamInfoListBinding
import es.gdebustamante.inadraft.ui.adapter.TeamAdapter
import es.gdebustamante.inadraft.ui.view.base.BaseFragment
import es.gdebustamante.inadraft.ui.view.bindingExtension.*
import es.gdebustamante.inadraft.ui.viewmodel.TeamInfoListVM

@AndroidEntryPoint
class TeamInfoListFragment : BaseFragment<FragmentTeamInfoListBinding>() {

    private val viewModel: TeamInfoListVM by viewModels()
    private val adapter = TeamAdapter { binding?.onTeamClicked(it) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateViewBinding(inflater, container)
        binding?.apply {
            teamInfoListFragmentLoading.root.startShimmer()
            setupRecyclerView(adapter)
            setupDrawerWithFragmentToolbar(infoTeamFragmentToolbarTop)
            setupListeners(viewModel)
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupVMObservers()
        viewModel.loadTeamList()
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTeamInfoListBinding = FragmentTeamInfoListBinding.inflate(inflater, container, false)

    private fun setupVMObservers(){
        viewModel.teamList.observe(viewLifecycleOwner) { binding?.onTeamListChanged(it, adapter) }
        viewModel.progressVisible.observe(viewLifecycleOwner) { binding?.onProgressVisibleChanged(it) }
    }
}
