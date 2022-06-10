package es.gdebustamante.inadraft.ui.view.dialog.choosePlayer

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import es.gdebustamante.inadraft.databinding.DialogChoosePlayerBinding
import es.gdebustamante.inadraft.ui.adapter.PlayerMiniGameAdapter
import es.gdebustamante.inadraft.ui.viewmodel.ChoosePlayerVM

private const val PLAYER_POSITION_ID_DEFAULT = -1

/**
 * Cuadro de diálogo para mostrar un listado de jugadores al usuario y obligarle a elegir uno
 *
 * @see <a href="https://developer.android.com/guide/topics/ui/dialogs?hl=es-419">DialogFragment</a>
 */
@AndroidEntryPoint
class ChoosePlayerDialog : DialogFragment() {

    //region class attributes

    private val args: ChoosePlayerDialogArgs by navArgs()
    private var binding: DialogChoosePlayerBinding? = null
    private var adapter: PlayerMiniGameAdapter? = null
    private val viewModel: ChoosePlayerVM by viewModels()

    //endregion

    //region override methods

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        isCancelable = false
        adapter = PlayerMiniGameAdapter {
            getListener()?.putPlayerInCard(it.id, args.playerCardId)
            dismiss()
        }.also {
            binding?.choosePlayerDialogListOfPlayers?.adapter = it
        }
        return binding?.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogChoosePlayerBinding.inflate(layoutInflater)
        return MaterialAlertDialogBuilder(requireActivity())
            .setView(binding?.root)
            .setCancelable(false)
            .create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (args.playerPositionId != PLAYER_POSITION_ID_DEFAULT) {
            setupVMObservers()
            viewModel.loadRandomPlayers(args.playerPositionId)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        adapter = null
    }

    //endregion

    //region private methods

    private fun getListener(): ChoosePlayerListener? {
        val targetFragmentIndex = parentFragmentManager.fragments.size - 2
        val targetFragment = parentFragmentManager.fragments[targetFragmentIndex]
        return when {
            targetFragment is ChoosePlayerListener -> targetFragment as ChoosePlayerListener
            parentFragment is ChoosePlayerListener -> parentFragment as ChoosePlayerListener
            activity is ChoosePlayerListener -> activity as ChoosePlayerListener
            else -> null
        }
    }

    /**
     * Observa los liveData del VM y su comportamiento cuando estos cambiem
     */
    private fun setupVMObservers(){
        viewModel.randomPlayers.observe(viewLifecycleOwner) {
            adapter?.submitList(it.toList())
        }
    }

    //endregion

}

