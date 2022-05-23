package es.gdebustamante.inadraft.entity

import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.domain.PositionBO
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.entity.dto.PlayerDTO
import es.gdebustamante.inadraft.entity.dto.PositionDTO
import es.gdebustamante.inadraft.entity.dto.TeamDTO

fun PlayerDTO.toBO(): PlayerBO = PlayerBO(
    id ?: -1,
    name ?: "",
    kick ?: -1,
    body ?: -1,
    control ?: -1,
    guard ?: -1,
    speed ?: -1,
    stamina ?: -1,
    guts ?: -1,
    photo ?: "",
    TeamBO(teamId ?: -1, "", ""),
    PositionBO(positionId ?: -1, "")
)

fun TeamDTO.toBO() = TeamBO(
    id ?: -1,
    name ?: "",
    shield ?: ""
)

fun PositionDTO.toBO() : PositionBO = PositionBO(
    id ?: -1,
    name ?: "",
)


