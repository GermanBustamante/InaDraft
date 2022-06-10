package es.gdebustamante.inadraft.ui.view.dialog.scoreGame

import es.gdebustamante.inadraft.ui.view.dialog.choosePlayer.ChoosePlayerDialog

/**
 * Interface para linkear [Formation442Fragment] y [ScoreGameDialog], de que dado una acción en [ScoreGameDialog], ocurrirá
 * algo en [Formation442Fragment] en función de lo sobreescribido en este.
 */
interface ScoreGameListener {

    fun finishDraft()

}