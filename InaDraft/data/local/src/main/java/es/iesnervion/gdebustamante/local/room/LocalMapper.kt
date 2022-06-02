package es.iesnervion.gdebustamante.local.room

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import es.gdebustamante.inadraft.domain.*
import es.iesnervion.gdebustamante.local.room.dbo.entity.*
import es.iesnervion.gdebustamante.local.room.dbo.relation.GameWithFormation
import es.iesnervion.gdebustamante.local.room.dbo.relation.PlayerWithTeamAndPosition
import java.time.LocalDate

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

@SuppressLint("NewApi")
fun GameDBO.toBO() = GameBO(
    id,
    score ?: -1,
    date ?: LocalDate.parse("0000/00/00"),
    userNick ?: "",
    FormationBO(formationId ?: -1, "", "")
)

@RequiresApi(Build.VERSION_CODES.O)
fun GameWithFormation.toGameBO() = GameBO(
    game.id,
    game.score ?: -1,
    game.date ?: LocalDate.parse("0000/00/00"),
    game.userNick ?: "",
    formationDBO.toBO()
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
