package es.iesnervion.gdebustamante.local.room.dbo.relation

import androidx.room.Embedded
import androidx.room.Relation
import es.iesnervion.gdebustamante.local.room.dbo.entity.PlayerDBO
import es.iesnervion.gdebustamante.local.room.dbo.entity.PositionDBO
import es.iesnervion.gdebustamante.local.room.dbo.entity.TeamDBO

data class PlayerWithTeamAndPosition(
    @Embedded
    val player: PlayerDBO,

    @Relation(
        entity = PositionDBO::class,
        parentColumn = "positionId",
        entityColumn = "id"
    )
    val position: PositionDBO,

    @Relation(
        entity = TeamDBO::class,
        parentColumn = "teamId",
        entityColumn = "id"
    )
    val team: TeamDBO,
)
