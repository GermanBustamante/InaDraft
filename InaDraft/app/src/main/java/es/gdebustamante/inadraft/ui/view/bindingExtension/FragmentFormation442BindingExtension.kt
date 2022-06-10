package es.gdebustamante.inadraft.ui.view.bindingExtension

import android.content.res.ColorStateList
import android.view.View
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import es.gdebustamante.inadraft.R
import es.gdebustamante.inadraft.databinding.FragmentFormation442Binding
import es.gdebustamante.inadraft.databinding.PlayerMiniCardBinding
import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.ui.view.fragment.Formation442Fragment.Companion.FORMATION_4_4_2
import es.gdebustamante.inadraft.ui.view.fragment.Formation442FragmentDirections
import es.gdebustamante.inadraft.util.NUMBER_OF_PLAYERS
import es.gdebustamante.inadraft.util.loadGlideCenterImage

private const val GOALKEEPER_ABBREVIATED = "GK"
private const val DEFENSE_ABBREVIATED = "DF"
private const val MIDFIELD_ABBREVIATED = "MF"
private const val FORWARD_ABBREVIATED = "FW"
private const val FACTOR_RATING_BAR = 1.5
private const val COUNTER = 1

//region public methods

/**
 * Pinta los nombres previos de las posiciones de la carta
 */
fun FragmentFormation442Binding.setupInitialViews() {
    formation442BtnAddGame.iconTint =
        ColorStateList.valueOf(ContextCompat.getColor(root.context, R.color.white))
    PositionPreviewLabelGoalkeeper.root.text = GOALKEEPER_ABBREVIATED
    PositionPreviewLabelDefender1.root.text = DEFENSE_ABBREVIATED
    PositionPreviewLabelDefender2.root.text = DEFENSE_ABBREVIATED
    PositionPreviewLabelDefender3.root.text = DEFENSE_ABBREVIATED
    PositionPreviewLabelDefender4.root.text = DEFENSE_ABBREVIATED
    PositionPreviewLabelMidfielder1.root.text = MIDFIELD_ABBREVIATED
    PositionPreviewLabelMidfielder2.root.text = MIDFIELD_ABBREVIATED
    PositionPreviewLabelMidfielder3.root.text = MIDFIELD_ABBREVIATED
    PositionPreviewLabelMidfielder4.root.text = MIDFIELD_ABBREVIATED
    PositionPreviewLabelForward1.root.text = FORWARD_ABBREVIATED
    PositionPreviewLabelForward2.root.text = FORWARD_ABBREVIATED
    contentFormationBase.formationFragmentToolbarTittle.text = FORMATION_4_4_2
}

/**
 * Setea los click listeners para hacer las cartas clickables, definiendo su acción cuando ocurra esto
 */
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

/**
 * Setea las cartas clickables o no en función del parametro [isClickable]
 */
fun FragmentFormation442Binding.changeCardsClickable(isClickable : Boolean){
    formation442Goalkeeper.root.isClickable = isClickable
    formation442Defender1.root.isClickable = isClickable
    formation442Defender2.root.isClickable = isClickable
    formation442Defender3.root.isClickable = isClickable
    formation442Defender4.root.isClickable = isClickable
    formation442Midfielder1.root.isClickable = isClickable
    formation442Midfielder2.root.isClickable = isClickable
    formation442Midfielder3.root.isClickable = isClickable
    formation442Midfielder4.root.isClickable = isClickable
    formation442Forward1.root.isClickable = isClickable
    formation442Forward2.root.isClickable = isClickable
}

/**
 * Dado una playerCard en la que se ha clickado, setea todas las cartas no clickables y navega a un [DialogFragment] en el que se mostrará el listado
 * de jugadores aleatorios en función de la posición de la carta
 */
fun FragmentFormation442Binding.onPlayerCardClicked(playerCard: View) {
    changeCardsClickable(false)
    val playerPositionId = when (playerCard.id) {
        R.id.formation442Goalkeeper -> 1
        R.id.formation442Defender1, R.id.formation442Defender2, R.id.formation442Defender3, R.id.formation442Defender4 -> 2
        R.id.formation442Midfielder1, R.id.formation442Midfielder2, R.id.formation442Midfielder3, R.id.formation442Midfielder4 -> 3
        R.id.formation442Forward1, R.id.formation442Forward2 -> 4
        else -> -1
    }
    root.findNavController()
        .navigate(
            Formation442FragmentDirections.actionFormation442FragmentToChoosePlayerDialog(
                playerPositionId,
                playerCard.id
            )
        )
}

/**
 * Dado un listado de jugadores mapeado con los Ids de su carta correspondiente, pinta cada jugador en la carta.
 * Además, si ya han sido elegidos todos los jugadores (tamaño de la lista = 11), hace el botón de AddGame clickable para que el usuario
 * pueda guardar la partida y navegar a un [DialogFragment] para guardar esta
 */
fun FragmentFormation442Binding.onPlayersDraftChanged(
    playersMap: MutableMap<Int, PlayerBO>,
    formationId: Int,
) {
    drawAverageTeam(playersMap.values.toList())
    playersMap.forEach {
        drawPlayerInCard(it.value, it.key)
    }

    if (playersMap.size == NUMBER_OF_PLAYERS) {
        formation442BtnAddGame.apply {
            isEnabled = true
            setBackgroundColor((ContextCompat.getColor(root.context, R.color.colorPrimary)))
            setOnClickListener {
                val totalPunctuation = playersMap.values.sumOf { it.average }
                root.findNavController()
                    .navigate(
                        Formation442FragmentDirections.actionFormation442FragmentToScoreGameDialog(
                            totalPunctuation,
                            (totalPunctuation / NUMBER_OF_PLAYERS).toFloat(),
                            formationId
                        )
                    )
            }
        }
    }
}

//endregion

//region private methods

/**
 * Dado un id de una view carta y un jugador, llama a [drawPlayer] para pintar en un lugar específico
 */
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

/**
 * Pinta un jugador en una carta determinada
 */
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

/**
 * Pinta en una rating bar la media de un equipo sobre 5 y la media general en un texto
 */
private fun FragmentFormation442Binding.drawAverageTeam(players: List<PlayerBO>) {
    val averageTeamDraft = (players.sumOf { it.average } / NUMBER_OF_PLAYERS).toFloat()
    contentFormationBase.apply {
        formationFragmentToolbarRatingNumber.text = averageTeamDraft.toInt().toString()
        formationFragmentToolbarRatingBar.rating =
            (averageTeamDraft / NUMBER_OF_PLAYERS / FACTOR_RATING_BAR).toFloat()
    }
}

//endregion
