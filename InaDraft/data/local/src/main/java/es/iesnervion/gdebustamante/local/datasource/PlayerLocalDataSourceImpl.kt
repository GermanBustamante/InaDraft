package es.iesnervion.gdebustamante.local.datasource

import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.player.PlayerLocalDataSource
import es.iesnervion.gdebustamante.local.room.dao.PlayerDao

class PlayerLocalDataSourceImpl(
    private val playerDao : PlayerDao
) : PlayerLocalDataSource{
    override suspend fun getLocalPlayers(): List<PlayerBO> {
        return emptyList()
    }

    override suspend fun getLocalPlayersFromTeam(teamId: Int): List<PlayerBO> {
        return emptyList()
    }

    override suspend fun insertPlayers(players: List<PlayerBO>) {

    }
}