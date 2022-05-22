package es.iesnervion.gdebustamante.local.room.dbo.entity

import androidx.room.Entity

@Entity(tableName = "PlayersFormations", primaryKeys = ["playerId", "formationId"])
data class PlayerFormationCrossRef(
    val playerId: Int,
    val formationId: Int
)