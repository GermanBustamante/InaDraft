package es.iesnervion.gdebustamante.local.room.dbo.relation

import androidx.room.Embedded
import androidx.room.Relation
import es.iesnervion.gdebustamante.local.room.dbo.entity.FormationDBO
import es.iesnervion.gdebustamante.local.room.dbo.entity.GameDBO

data class GameWithFormation(
    @Embedded
    val game: GameDBO,

    @Relation(
        parentColumn = "formationId",
        entityColumn = "id"
    )
    val formation: FormationDBO,
)