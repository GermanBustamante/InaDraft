package es.gdebustamante.inadraft.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import es.gdebustamante.inadraft.databinding.FragmentFormation442Binding
import es.gdebustamante.inadraft.ui.view.base.BaseFragment
import es.gdebustamante.inadraft.ui.view.bindingExtension.onPlayersDraftChanged
import es.gdebustamante.inadraft.ui.view.bindingExtension.setupInitialViews
import es.gdebustamante.inadraft.ui.view.bindingExtension.setupListeners
import es.gdebustamante.inadraft.ui.view.dialog.choosePlayer.ChoosePlayerListener
import es.gdebustamante.inadraft.ui.view.dialog.scoreGame.ScoreGameListener
import es.gdebustamante.inadraft.ui.viewmodel.GameVM



@AndroidEntryPoint
class Formation442Fragment : BaseFragment<FragmentFormation442Binding>(), ChoosePlayerListener, ScoreGameListener {

    //region class attributes

    companion object{
        const val FORMATION_4_4_2 = "4-4-2"
    }

    private val args: Formation442FragmentArgs  by navArgs()
    private val viewModel : GameVM by viewModels()

    //endregion

    //region override methods

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = inflateViewBinding(inflater, container)
        binding?.apply {
            setupDrawerWithFragmentToolbar(contentFormationBase.formationFragmentToolbarTop)
            setupInitialViews()
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
        viewModel.loadPlayer(playerCardId,playerId)
    }

    override fun finishDraft() {
        requireActivity().onBackPressed()
        requireActivity().onBackPressed()
    }

    //endregion

    //region private methods

    private fun setupVMObservers(){
        viewModel.playersDraft.observe(viewLifecycleOwner){
            binding?.onPlayersDraftChanged(it, args.formationId)
        }
    }

    //endregion

}