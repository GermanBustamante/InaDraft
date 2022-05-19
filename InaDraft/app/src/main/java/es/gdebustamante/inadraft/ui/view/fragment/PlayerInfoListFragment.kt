package es.gdebustamante.inadraft.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import es.gdebustamante.inadraft.databinding.FragmentPlayerInfoListBinding
import es.gdebustamante.inadraft.ui.adapter.PlayerDetailAdapter
import es.gdebustamante.inadraft.ui.view.base.BaseFragment
import es.gdebustamante.inadraft.ui.view.bindingExtension.*
import es.gdebustamante.inadraft.ui.viewmodel.PlayerInfoListFragmentVM
import es.gdebustamante.inadraft.ui.viewmodel.TeamInfoListVM

@AndroidEntryPoint
class PlayerInfoListFragment : BaseFragment<FragmentPlayerInfoListBinding>() {

    private val viewModel: TeamInfoListVM by viewModels()
    private val adapter = PlayerDetailAdapter()
    private val args: PlayerInfoListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateViewBinding(inflater, container)
        binding?.apply {
            playerInfoListFragmentLoading.root.startShimmer()
            setupDrawerWithFragmentToolbar(playerInfoListFragmentToolbarTop)
            setupRecyclerView(adapter)
            setupListeners(viewModel, args.teamId)
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupVMObservers()
        viewModel.loadPlayersWithShieldAndPosition(args.teamId)
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlayerInfoListBinding =
        FragmentPlayerInfoListBinding.inflate(inflater, container, false)

    private fun setupVMObservers(){
        viewModel.playerList.observe(viewLifecycleOwner) {
            binding?.onPlayerListChanged(it)
        }
        viewModel.teamSelected.observe(viewLifecycleOwner){
            binding?.onTeamSelectedChanged(it)
        }
        viewModel.positionList.observe(viewLifecycleOwner){
            binding?.onPlayerPositionSelectedChanged(it, adapter)
        }
        viewModel.progressVisible.observe(viewLifecycleOwner) { binding?.onProgressVisibleChanged(it) }

    }
}



