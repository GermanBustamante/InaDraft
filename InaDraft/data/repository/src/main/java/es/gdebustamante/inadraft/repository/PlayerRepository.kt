package es.gdebustamante.inadraft.repository

import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.player.PlayerLocalDataSource
import es.gdebustamante.inadraft.player.PlayerRemoteDataSource

class PlayerRepository(private val playerRemoteDataSource : PlayerRemoteDataSource, private val playerLocalDataSource: PlayerLocalDataSource) {

    suspend fun getPlayerListByTeam(teamId : Int) : List<PlayerBO> = playerRemoteDataSource.getRemotePlayersFromTeam(teamId)

    suspend fun getPlayers(): List<PlayerBO> {
        var players = playerLocalDataSource.getLocalPlayers()
        if (players.isEmpty()){
            players = playerRemoteDataSource.getRemotePlayers()
            playerLocalDataSource.insertPlayers(players)
        }
        return players
    }
}