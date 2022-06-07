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
import es.gdebustamante.inadraft.ui.viewmodel.PlayerInfoListVM

@AndroidEntryPoint
class PlayerInfoListFragment : BaseFragment<FragmentPlayerInfoListBinding>() {

    //region class attributes

    private val viewModel: PlayerInfoListVM by viewModels()
    private var adapter : PlayerDetailAdapter? = null
    private val args: PlayerInfoListFragmentArgs by navArgs()

    //endregion

    //region override methods

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateViewBinding(inflater, container)
        binding?.apply {
            playerInfoListFragmentLoading.root.startShimmer()
            setupDrawerWithFragmentToolbar(playerInfoListFragmentToolbarTop)
            adapter = PlayerDetailAdapter().also {
                setupRecyclerView(it)
            }
            setupListeners(viewModel, args.teamId)
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupVMObservers()
        viewModel.loadPlayerByTeam(args.teamId)
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlayerInfoListBinding =
        FragmentPlayerInfoListBinding.inflate(inflater, container, false)

    override fun onDestroyView() {
        super.onDestroyView()
        adapter = null
        binding = null
    }
    //endregion

    //region private methods

    private fun setupVMObservers(){
        viewModel.playerList.observe(viewLifecycleOwner) {
            adapter?.let { adapter -> binding?.onPlayerListChanged(it, adapter) }
        }
        viewModel.progressVisible.observe(viewLifecycleOwner) { binding?.onProgressVisibleChanged(it) }
    }

    //endregion
}



