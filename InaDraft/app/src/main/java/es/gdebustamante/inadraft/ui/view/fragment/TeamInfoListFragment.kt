package es.gdebustamante.inadraft.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import es.gdebustamante.inadraft.R
import es.gdebustamante.inadraft.databinding.FragmentTeamInfoListBinding
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.ui.adapter.TeamAdapter
import es.gdebustamante.inadraft.ui.view.base.BaseFragment
import es.gdebustamante.inadraft.ui.view.bindingExtension.onProgressVisibleChanged
import es.gdebustamante.inadraft.ui.view.bindingExtension.onTeamClicked
import es.gdebustamante.inadraft.ui.view.bindingExtension.onTeamListChanged
import es.gdebustamante.inadraft.ui.view.bindingExtension.setupRecyclerView
import es.gdebustamante.inadraft.ui.viewmodel.InaDraftVM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TeamInfoListFragment : BaseFragment<FragmentTeamInfoListBinding>() {

    private val viewModel: InaDraftVM by viewModels()
    private val adapter = TeamAdapter { binding?.onTeamClicked(it) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateViewBinding(inflater, container)
        binding?.apply {
            setupRecyclerView(adapter)
            setupDrawerWithFragmentToolbar(infoTeamFragmentToolbarTop)
            infoTeamFragmentToolbarTop.title = getString(R.string.fragment_team_info_list__toolbar_tittle)
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.teamList.observe(viewLifecycleOwner) { teamList ->
            binding?.onTeamListChanged(teamList, adapter)
        }

        viewModel.progressVisible.observe(viewLifecycleOwner) { binding?.onProgressVisibleChanged(it) }
        viewModel.loadTeamList()
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTeamInfoListBinding = FragmentTeamInfoListBinding.inflate(inflater, container, false)

}
