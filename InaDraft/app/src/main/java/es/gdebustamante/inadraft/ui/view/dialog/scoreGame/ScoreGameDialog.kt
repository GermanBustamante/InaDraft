package es.gdebustamante.inadraft.ui.view.dialog.scoreGame

import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import es.gdebustamante.inadraft.R
import es.gdebustamante.inadraft.databinding.DialogScoreGameBinding
import es.gdebustamante.inadraft.domain.FormationBO
import es.gdebustamante.inadraft.domain.GameBO
import es.gdebustamante.inadraft.util.NUMBER_OF_PLAYERS
import es.gdebustamante.inadraft.ui.view.dialog.choosePlayer.ChoosePlayerListener
import es.gdebustamante.inadraft.ui.viewmodel.ScoreGameVM
import es.gdebustamante.inadraft.util.showToast
import java.time.Instant
import java.util.*

private const val GENERIC_USER_NICK = "Invitado"

@AndroidEntryPoint
class ScoreGameDialog : DialogFragment() {

    //region class attributes

    private val args: ScoreGameDialogArgs by navArgs()
    private var binding: DialogScoreGameBinding? = null
    private val viewModel: ScoreGameVM by viewModels()

    //endregion

    //region override methods

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        isCancelable = false
        binding?.apply {
            setupViews(args.totalPunctuation, args.teamAverage)
            setupListeners(args.teamAverage, args.formationId)
        }
        return binding?.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogScoreGameBinding.inflate(layoutInflater)
        return MaterialAlertDialogBuilder(requireActivity())
            .setView(binding?.root)
            .setCancelable(false)
            .create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupVMObservers()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    //endregion

    //region private methods

    @RequiresApi(Build.VERSION_CODES.O)
    private fun DialogScoreGameBinding.setupViews(
        totalPunctuation: Int,
        teamAverage: Float,
    ) {
        scoreGameDialogRatingBarTeamMedia.rating = (teamAverage / NUMBER_OF_PLAYERS / 1.5).toFloat()
        scoreGameDialogLabelTotalScore.text = totalPunctuation.toString()
        scoreGameDialogLabelTeamMedia.text = teamAverage.toInt().toString()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun DialogScoreGameBinding.setupListeners(teamAverage: Float, formationId: Int) {
        scoreGameDialogBtnAddGame.setOnClickListener {

            root.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.loadingGrayTransparent))
            it.isEnabled = false
            scoreGameDialogProgressIndicatorLoadingAddGame.isVisible = true

            viewModel.insertGame(
                GameBO(
                    0, teamAverage.toInt(),
                    Date.from(Instant.now()),
                    scoreGameDialogInputLayUserNick.text.toString().ifBlank { GENERIC_USER_NICK },
                    FormationBO(id = formationId)
                )
            )

        }
    }

    private fun getListener(): ScoreGameListener? {
        val targetFragmentIndex = parentFragmentManager.fragments.size - 2
        val targetFragment = parentFragmentManager.fragments[targetFragmentIndex]
        return when {
            targetFragment is ChoosePlayerListener -> targetFragment as ScoreGameListener
            parentFragment is ChoosePlayerListener -> parentFragment as ScoreGameListener
            activity is ChoosePlayerListener -> activity as ScoreGameListener
            else -> null
        }
    }

    private fun setupVMObservers() {
        viewModel.operationSuccess.observe(viewLifecycleOwner) {
            if (it) {
                showToast(getString(R.string.dialog_score_game__snackbar__game_added_success))
                getListener()?.finishDraft()
            }
        }
    }

    //endregion
}