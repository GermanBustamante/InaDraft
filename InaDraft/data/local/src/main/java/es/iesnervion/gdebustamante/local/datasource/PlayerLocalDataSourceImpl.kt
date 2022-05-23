package es.iesnervion.gdebustamante.local.datasource

import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.player.PlayerLocalDataSource
import es.iesnervion.gdebustamante.local.room.dao.PlayerDao
import es.iesnervion.gdebustamante.local.room.toDBO
import es.iesnervion.gdebustamante.local.room.toPlayerBO

class PlayerLocalDataSourceImpl(
    private val playerDao : PlayerDao,
) : PlayerLocalDataSource{
    override suspend fun getLocalPlayers(): List<PlayerBO> {
        return playerDao.getPlayers().map { it.toPlayerBO() }
    }

    override suspend fun getLocalPlayersFromTeam(teamId: Int): List<PlayerBO> =
        playerDao.getPlayersFromTeam(teamId).map { it.toPlayerBO() }

    override suspend fun insertPlayers(players: List<PlayerBO>) {
        playerDao.insertPlayers(players.map { it.toDBO() })
    }
}


