package es.iesnervion.gdebustamante.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import es.iesnervion.gdebustamante.local.room.dbo.entity.PositionDBO

@Dao
interface PositionDao {

    //region insert

    @Insert
    suspend fun insertPositions(positions : List<PositionDBO>)

    //endregion
}