package es.iesnervion.gdebustamante.local.room

import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.domain.PositionBO
import es.gdebustamante.inadraft.domain.TeamBO
import es.iesnervion.gdebustamante.local.room.dbo.entity.PlayerDBO
import es.iesnervion.gdebustamante.local.room.dbo.entity.PositionDBO
import es.iesnervion.gdebustamante.local.room.dbo.entity.TeamDBO
import es.iesnervion.gdebustamante.local.room.dbo.relation.PlayerWithTeamAndPosition

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

//fun PlayersWithTeam.toPlayerListBO(positions: List<PositionBO>): List<PlayerBO> {
//    val playersCompleted = mutableListOf<PlayerBO>()
//    players.forEach {
//        playersCompleted.add(
//            PlayerBO(
//                it.id,
//                it.name ?: "",
//                it.kick ?: 0,
//                it.body ?: 0,
//                it.control ?: 0,
//                it.guard ?: 0,
//                it.speed ?: 0,
//                it.stamina ?: 0,
//                it.guts ?: 0,
//                it.photo ?: "",
//                team.toBO(),
//                positions.first { position -> position.id == it.positionId }
//            )
//        )
//    }
//    return playersCompleted
//}
//
//fun PlayersWithPosition.toPlayerListBO(teams: List<TeamBO>): List<PlayerBO> {
//    val playersCompleted = mutableListOf<PlayerBO>()
//    players.forEach {
//        playersCompleted.add(
//            PlayerBO(
//                it.id,
//                it.name ?: "",
//                it.kick ?: 0,
//                it.body ?: 0,
//                it.control ?: 0,
//                it.guard ?: 0,
//                it.speed ?: 0,
//                it.stamina ?: 0,
//                it.guts ?: 0,
//                it.photo ?: "",
//                teams.first { team -> team.id == it.teamId },
//                position.toBO()
//            )
//        )
//    }
//    return playersCompleted
//}
