package es.iesnervion.gdebustamante.local.datasource

import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.player.PlayerLocalDataSource

class PlayerLocalDataSourceImpl: PlayerLocalDataSource {
    override suspend fun getLocalPlayers(): List<PlayerBO> {
        return emptyList()
    }

    override suspend fun getLocalPlayersFromTeam(teamId: Int): List<PlayerBO> {
        return emptyList()
    }

    override suspend fun insertPlayers(players: List<PlayerBO>) {

    }
}