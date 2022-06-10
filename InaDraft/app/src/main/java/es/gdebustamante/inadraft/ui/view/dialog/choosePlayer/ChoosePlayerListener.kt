package es.gdebustamante.inadraft.ui.view.dialog.choosePlayer

/**
 * Interface para linkear [Formation442Fragment] y [ChoosePlayerDialog], de que dado una acción en [ChoosePlayerDialog], ocurrirá
 * algo en [Formation442Fragment] en función de lo sobreescribido en este.
 */
interface ChoosePlayerListener {
    fun putPlayerInCard(playerId : Int, playerCardId: Int)
}