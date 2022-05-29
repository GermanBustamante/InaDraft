package es.iesnervion.gdebustamante.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import es.iesnervion.gdebustamante.local.room.dbo.entity.PlayerDBO
import es.iesnervion.gdebustamante.local.room.dbo.relation.PlayersWithTeam
import es.iesnervion.gdebustamante.local.room.dbo.relation.PlayerWithTeamAndPosition

@Dao
interface PlayerDao {

    //region queries

    @Transaction
    @Query("SELECT * FROM players")
    suspend fun getPlayers(): List<PlayerWithTeamAndPosition>

    @Transaction
    @Query("SELECT * FROM players WHERE teamId = :teamId")
    suspend fun getPlayersFromTeam(teamId : Int) : List<PlayerWithTeamAndPosition>

//    //TODO VER COMO MEJORARLO
//    @Transaction
//    @Query("SELECT * FROM players WHERE ((kick + body + control + guard + speed + stamina + guts + photo)/7) >= 70")
//    suspend fun getPlayersWithHighAverage(): List<PlayersWithTeam>

    @Transaction
    @Query("SELECT * FROM players WHERE positionId = :positionId ORDER BY RANDOM() LIMIT 6")
    suspend fun getRandomPlayersByPosition(positionId : Int): List<PlayerWithTeamAndPosition>

    @Transaction
    @Query("SELECT * FROM players WHERE id = :playerId")
    suspend fun getPlayer(playerId: Int): PlayerWithTeamAndPosition
    //endregion

    //region insert

    @Insert
    suspend fun insertPlayers(players : List<PlayerDBO>)

    //endregion

}