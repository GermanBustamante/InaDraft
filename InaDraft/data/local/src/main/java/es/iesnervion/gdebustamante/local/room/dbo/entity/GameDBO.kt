package es.iesnervion.gdebustamante.local.room.dbo.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "games")
data class GameDBO(
    @PrimaryKey(autoGenerate = true) val id : Int,
    val date : Date? = Date(),
    val score : Int?,
    val userNick : String?,
    val formationId : Int
)