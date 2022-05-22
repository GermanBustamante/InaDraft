package es.iesnervion.gdebustamante.local.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import es.iesnervion.gdebustamante.local.room.dao.PlayerDao
import es.iesnervion.gdebustamante.local.room.dao.PositionDao
import es.iesnervion.gdebustamante.local.room.dao.TeamDao
import es.iesnervion.gdebustamante.local.room.dbo.entity.*

@Database(
    entities = [PlayerDBO::class, TeamDBO::class, PositionDBO::class,
        PlayerFormationCrossRef::class, FormationDBO::class, GameDBO::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class InaDraftDatabase : RoomDatabase() {

    abstract fun getPlayerDao(): PlayerDao

    abstract fun getTeamDao(): TeamDao

    abstract fun getPositionDao(): PositionDao

}