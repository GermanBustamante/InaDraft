package es.gdebustamante.inadraft.ui.view.vo

import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.domain.PositionBO
import es.gdebustamante.inadraft.domain.TeamBO

//Vista para mostrar la carta con el logo
data class PlayerDetailVO (val player: PlayerBO, val team : TeamBO, val position: PositionBO)

fun PlayerBO.toPlayerWithShieldVO(team: TeamBO, position: PositionBO) : PlayerDetailVO = PlayerDetailVO(
    this, team, position
)