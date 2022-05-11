package es.gdebustamante.inadraft.ui.view.vo

import es.gdebustamante.inadraft.domain.PlayerBO

//Vista para mostrar la carta con el logo
data class PlayerWithShieldVO (val player: PlayerBO, val shield : String)

fun PlayerBO.toPlayerWithShieldVO(shieldUrl : String) : PlayerWithShieldVO = PlayerWithShieldVO(
    this, shieldUrl
)