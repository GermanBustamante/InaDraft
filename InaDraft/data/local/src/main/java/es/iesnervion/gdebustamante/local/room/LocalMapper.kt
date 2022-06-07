package es.iesnervion.gdebustamante.local.room

import es.gdebustamante.inadraft.domain.*
import es.iesnervion.gdebustamante.local.room.dbo.entity.*
import es.iesnervion.gdebustamante.local.room.dbo.relation.GameWithFormation
import es.iesnervion.gdebustamante.local.room.dbo.relation.PlayerWithTeamAndPosition
import java.util.*

fun PlayerWithTeamAndPosition.toPlayerBO() =
    PlayerBO(
        player.id,
        player.name ?: "",
        player.kick ?: 0,
        player.body ?: 0,
        player.control ?: 0,
        player.guard ?: 0,
        player.speed ?: 0,
        player.stamina ?: 0,
        player.guts ?: 0,
        player.photo ?: "",
        team.toBO(),
        position.toBO()
    )

fun PlayerBO.toDBO() = PlayerDBO(
    id,
    name,
    kick,
    body,
    control,
    guard,
    speed,
    stamina,
    guts,
    photo,
    team.id,
    position.id
)

fun TeamDBO.toBO() = TeamBO(
    id,
    name ?: "",
    photo ?: ""
)

fun PositionDBO.toBO() = PositionBO(
    id,
    name ?: ""
)

fun TeamBO.toDBO() = TeamDBO(
    id,
    name,
    shield
)

fun PositionBO.toDBO() = PositionDBO(
    id,
    name
)

fun FormationDBO.toBO() = FormationBO(
    id,
    name ?: "",
    photo ?: ""
)

fun FormationBO.toDBO() = FormationDBO(
    id,
    name,
    photo
)

fun GameBO.toDBO() = GameDBO(
    id,
    date,
    score,
    userNick,
    formation.id
)

fun GameDBO.toBO() = GameBO(
    id,
    score ?: -1,
    date ?: Date(),
    userNick ?: "",
    FormationBO(id = formationId)
)

fun GameWithFormation.toGameBO() = GameBO(
    game.id,
    game.score ?: -1,
    game.date ?: Date(),
    game.userNick ?: "",
    formation.toBO()
)
