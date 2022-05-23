package es.iesnervion.gdebustamante.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import es.iesnervion.gdebustamante.local.room.dbo.entity.PositionDBO

@Dao
interface PositionDao {

    //region queries

    @Query("SELECT * FROM positions")
    suspend fun getPositions(): List<PositionDBO>

    //endregion


    //region insert

    @Insert
    suspend fun insertPositions(positions : List<PositionDBO>)

    //endregion
}