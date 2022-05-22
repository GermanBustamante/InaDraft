package es.iesnervion.gdebustamante.local.room.dbo.relation

import androidx.room.Embedded
import androidx.room.Relation
import es.iesnervion.gdebustamante.local.room.dbo.entity.PlayerDBO
import es.iesnervion.gdebustamante.local.room.dbo.entity.PositionDBO

data class PlayersWithPosition(
    @Embedded
    val position: PositionDBO,
    @Relation(
        parentColumn = "id",
        entityColumn = "positionId"
    )
    val players: List<PlayerDBO>
)