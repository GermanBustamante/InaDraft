package es.iesnervion.gdebustamante.local.room.dbo.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "players")
data class PlayerDBO(
    @PrimaryKey val id: Int,
    val name: String?,
    val kick: Int?,
    val body: Int?,
    val control: Int?,
    val guard: Int?,
    val speed: Int?,
    val stamina: Int?,
    val guts: Int?,
    val photo: String?,
    val teamId: Int?,
    val positionId: Int?
)

//((kick ?: -1 + body!! + control!! + guard!! + speed!! + stamina!! + guts!!) / 7).toDouble()