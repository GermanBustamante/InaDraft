package es.iesnervion.gdebustamante.local.room.dbo.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.*

@Entity(tableName = "games")
data class GameDBO(
    @PrimaryKey(autoGenerate = true) val id : Int,
    val date : LocalDate?,
    val score : Int?,
    val userNick : String?,
    val formationId : Int?
)