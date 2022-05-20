package es.gdebustamante.inadraft.player

import es.gdebustamante.inadraft.domain.PlayerBO

interface PlayerRemoteDataSource {

    suspend fun getRemotePlayers(): List<PlayerBO>

    suspend fun getRemotePlayersFromTeam(teamId : Int): List<PlayerBO>
}