package es.iesnervion.gdebustamante.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import es.iesnervion.gdebustamante.local.room.dbo.entity.TeamDBO

@Dao
interface TeamDao {

    //region queries

    @Transaction
    @Query("SELECT * FROM teams")
    suspend fun getTeams(): List<TeamDBO>

    //endregion

    //region insert

    @Insert
    suspend fun insertTeams(teams : List<TeamDBO>)

    //endregion
}