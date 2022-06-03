package es.iesnervion.gdebustamante.local.room.dao

import androidx.room.*
import es.iesnervion.gdebustamante.local.room.dbo.entity.GameDBO
import es.iesnervion.gdebustamante.local.room.dbo.relation.GameWithFormation

@Dao
interface GameDao {

    //region gets

    @Transaction
    @Query("SELECT * FROM games")
    suspend fun getGames(): List<GameWithFormation>

    @Query("SELECT id FROM games ORDER BY id DESC LIMIT 1")
    suspend fun getLastGame(): GameWithFormation

    //endregion

    //region insert

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGames(map: List<GameDBO>)

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(toDBO: GameDBO): Long

    //endregion
}