package es.iesnervion.gdebustamante.local.room.dbo.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import es.iesnervion.gdebustamante.local.room.dbo.entity.FormationDBO
import es.iesnervion.gdebustamante.local.room.dbo.entity.PlayerDBO
import es.iesnervion.gdebustamante.local.room.dbo.entity.PlayerFormationCrossRef

data class PlayersWithFormation(
    @Embedded val formation: FormationDBO,
    @Relation(
        parentColumn = "formationId",
        entityColumn = "playerId",
        associateBy = Junction(PlayerFormationCrossRef::class)
    )
    val players : List<PlayerDBO>
    )
