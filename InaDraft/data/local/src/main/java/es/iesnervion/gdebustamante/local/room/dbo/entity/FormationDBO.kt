package es.iesnervion.gdebustamante.local.room.dbo.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "formations")
data class FormationDBO (
    @PrimaryKey val id : Int,
    val name : String?,
    val photo : String?
)