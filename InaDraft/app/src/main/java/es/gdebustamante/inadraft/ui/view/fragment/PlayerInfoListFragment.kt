package es.gdebustamante.inadraft.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import es.gdebustamante.inadraft.databinding.FragmentPlayerInfoListBinding
import es.gdebustamante.inadraft.ui.adapter.PlayerDetailAdapter
import es.gdebustamante.inadraft.ui.view.base.BaseFragment
import es.gdebustamante.inadraft.ui.view.bindingExtension.onPlayerListChanged
import es.gdebustamante.inadraft.ui.view.bindingExtension.setupRecyclerView
import es.gdebustamante.inadraft.ui.viewmodel.InaDraftVM

@AndroidEntryPoint
class PlayerInfoListFragment : BaseFragment<FragmentPlayerInfoListBinding>() {

    private val viewModel: InaDraftVM by activityViewModels()
    private val adapter = PlayerDetailAdapter()
    private val args: PlayerInfoListFragmentArgs by navArgs()

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
        viewModel.playerSelected.observe(viewLifecycleOwner) {
            binding?.onPlayerListChanged(
                it,
                args.urlShield,
                adapter
            )
        }
        viewModel.loadPlayerListByTeamId(args.teamId)
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlayerInfoListBinding =
        FragmentPlayerInfoListBinding.inflate(inflater, container, false)


}



