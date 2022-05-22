package es.iesnervion.gdebustamante.local.room.dbo.relation

import androidx.room.Embedded
import androidx.room.Relation
import es.iesnervion.gdebustamante.local.room.dbo.entity.PlayerDBO
import es.iesnervion.gdebustamante.local.room.dbo.entity.TeamDBO

data class PlayersWithTeam (
    @Embedded
    val team: TeamDBO,
    @Relation(
        parentColumn = "id",
        entityColumn = "teamId"
    )
    val players: List<PlayerDBO>
)