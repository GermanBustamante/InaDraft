package es.gdebustamante.inadraft.ui.view.bindingExtension

import android.view.View
import androidx.navigation.findNavController
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import es.gdebustamante.inadraft.R
import es.gdebustamante.inadraft.databinding.FragmentFormation442Binding
import es.gdebustamante.inadraft.databinding.PlayerMiniCardBinding
import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.ui.view.fragment.Formation442FragmentDirections
import es.gdebustamante.inadraft.util.loadGlideCenterImage
import java.lang.IllegalStateException

//region public methods

fun FragmentFormation442Binding.setupInitialViews() {
    PositionPreviewLabelGoalkeeper.root.text = "GK"
    PositionPreviewLabelDefender1.root.text = "DF"
    PositionPreviewLabelDefender2.root.text = "DF"
    PositionPreviewLabelDefender3.root.text = "DF"
    PositionPreviewLabelDefender4.root.text = "DF"
    PositionPreviewLabelMidfielder1.root.text = "MF"
    PositionPreviewLabelMidfielder2.root.text = "MF"
    PositionPreviewLabelMidfielder3.root.text = "MF"
    PositionPreviewLabelMidfielder4.root.text = "MF"
    PositionPreviewLabelForward1.root.text = "FW"
    PositionPreviewLabelForward2.root.text = "FW"
    contentFormationBase.formationFragmentToolbarTittle.text = "4-4-2"
}

fun FragmentFormation442Binding.setupListeners() {
    formation442Goalkeeper.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Defender1.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Defender2.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Defender3.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Defender4.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Midfielder1.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Midfielder2.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Midfielder3.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Midfielder4.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Forward1.root.setOnClickListener { onPlayerCardClicked(it) }
    formation442Forward2.root.setOnClickListener { onPlayerCardClicked(it) }

}

fun FragmentFormation442Binding.onPlayerCardClicked(playerCard: View) {
    val playerPositionId = when (playerCard.id) {
        R.id.formation442Goalkeeper -> 1
        R.id.formation442Defender1, R.id.formation442Defender2, R.id.formation442Defender3, R.id.formation442Defender4 -> 2
        R.id.formation442Midfielder1, R.id.formation442Midfielder2, R.id.formation442Midfielder3, R.id.formation442Midfielder4 -> 3
        R.id.formation442Forward1, R.id.formation442Forward2 -> 4
        else -> -1
    }
    root.findNavController()
        .navigate(Formation442FragmentDirections.actionFormation442FragmentToChoosePlayerDialog(
            playerPositionId,
            playerCard.id))
}

fun FragmentFormation442Binding.onPlayersDraftChanged(
    playersMap: MutableMap<Int, PlayerBO>,
    formationId: Int,
) {
// TODO MEJORAR AUNQUE NO CAUSA NINGUN PROBLEMA DE RENDIMIENTO
    drawAverageTeam(playersMap.values.toList())
    playersMap.forEach {
        drawPlayerInCard(it.value, it.key)
    }

    if (playersMap.size == 11) {
        formation442BtnAddGame.isEnabled = true
        formation442BtnAddGame.setOnClickListener {
            val totalPunctuation = playersMap.values.sumOf { it.average }
                root.findNavController()
                    .navigate(Formation442FragmentDirections.actionFormation442FragmentToScoreGameDialog(
                        totalPunctuation, (totalPunctuation / 11).toFloat(), formationId))
        }
    }
}


//endregion

//region private methods

private fun drawPlayer(playerCardMiniBinding: PlayerMiniCardBinding, player: PlayerBO) {
    playerCardMiniBinding.apply {
        root.isClickable = false
        playerMiniCardLabelPlayerMedia.text = player.average.toString()
        playerMiniCardLabelPlayerPosition.text = player.position.name
        playerMiniCardImgPlayerShield.loadGlideCenterImage(player.team.shield)
        playerMiniCardImgPlayerPhoto.loadGlideCenterImage(player.photo)
        playerMiniCardLabelPlayerName.text = player.firstName
    }
}

private fun FragmentFormation442Binding.drawPlayerInCard(player: PlayerBO, playerCardId: Int?) {
    when (playerCardId) {
        R.id.formation442Goalkeeper -> drawPlayer(formation442Goalkeeper, player)
        R.id.formation442Defender1 -> drawPlayer(formation442Defender1, player)
        R.id.formation442Defender2 -> drawPlayer(formation442Defender2, player)
        R.id.formation442Defender3 -> drawPlayer(formation442Defender3, player)
        R.id.formation442Defender4 -> drawPlayer(formation442Defender4, player)
        R.id.formation442Midfielder1 -> drawPlayer(formation442Midfielder1, player)
        R.id.formation442Midfielder2 -> drawPlayer(formation442Midfielder2, player)
        R.id.formation442Midfielder3 -> drawPlayer(formation442Midfielder3, player)
        R.id.formation442Midfielder4 -> drawPlayer(formation442Midfielder4, player)
        R.id.formation442Forward1 -> drawPlayer(formation442Forward1, player)
        R.id.formation442Forward2 -> drawPlayer(formation442Forward2, player)
    }
}

private fun FragmentFormation442Binding.drawAverageTeam(players: List<PlayerBO>) {
    val averageTeamDraft = (players.sumOf { it.average } / 11).toFloat()
    contentFormationBase.apply {
        formationFragmentToolbarRatingNumber.text = averageTeamDraft.toInt().toString()
        formationFragmentToolbarRatingBar.rating = averageTeamDraft
    }
}

//endregion
