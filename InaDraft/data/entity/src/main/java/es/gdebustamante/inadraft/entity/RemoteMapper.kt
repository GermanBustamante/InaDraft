package es.gdebustamante.inadraft.entity

import es.gdebustamante.inadraft.domain.*
import es.gdebustamante.inadraft.entity.dto.*
import java.util.Date
import java.text.DateFormat.getDateInstance

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

fun PositionDTO.toBO(): PositionBO = PositionBO(
    id ?: -1,
    name ?: "",
)

fun FormationDTO.toBO(): FormationBO = FormationBO(
    id ?: -1,
    name ?: "",
    photo ?: ""
)

fun GameDTO.toBO() = GameBO(
    id ?: -1,
    score ?: -1,
    ((date ?: getDateInstance()) as Date),
    userNick ?: "",
    FormationBO(formationId ?: -1, "", "")
)


