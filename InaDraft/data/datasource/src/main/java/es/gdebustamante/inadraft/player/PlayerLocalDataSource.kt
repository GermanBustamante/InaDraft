package es.gdebustamante.inadraft.player

import es.gdebustamante.inadraft.domain.PlayerBO

interface PlayerLocalDataSource {

    suspend fun getLocalPlayers(): List<PlayerBO>

    suspend fun getLocalPlayersFromTeam(teamId : Int): List<PlayerBO>

    suspend fun insertPlayers(players: List<PlayerBO>)

}