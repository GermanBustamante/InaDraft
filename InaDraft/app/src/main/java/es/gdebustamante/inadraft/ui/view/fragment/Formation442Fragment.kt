package es.gdebustamante.inadraft.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import es.gdebustamante.inadraft.databinding.FragmentFormation442Binding
import es.gdebustamante.inadraft.ui.view.base.BaseFragment
import es.gdebustamante.inadraft.ui.view.bindingExtension.onPlayersDraftChanged
import es.gdebustamante.inadraft.ui.view.bindingExtension.setupCardsPositions
import es.gdebustamante.inadraft.ui.view.bindingExtension.setupListeners
import es.gdebustamante.inadraft.ui.view.dialog.ChoosePlayerListener
import es.gdebustamante.inadraft.ui.viewmodel.GameVM

@AndroidEntryPoint
class Formation442Fragment : BaseFragment<FragmentFormation442Binding>(), ChoosePlayerListener {

    //region class attributes

//    private val args: Formation442FragmentArgs  by navArgs()
    private val viewModel : GameVM by viewModels()
    private var playerCardId : Int? = null

    //endregion

    //region override methods

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = inflateViewBinding(inflater, container)
        binding?.apply {
            setupDrawerWithFragmentToolbar(contentFormationBase.formationFragmentToolbarTop)
            setupCardsPositions()
            setupListeners()
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupVMObservers()
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentFormation442Binding =
        FragmentFormation442Binding.inflate(inflater, container, false)

    override fun putPlayerInCard(playerId: Int, playerCardId: Int) {
        this.playerCardId = playerCardId
        viewModel.loadPlayer(playerId)
    }

    //endregion

    //region private methods

    private fun setupVMObservers(){
        viewModel.playersDraft.observe(viewLifecycleOwner){
            binding?.onPlayersDraftChanged(it, playerCardId)
        }
    }

    //endregion

}