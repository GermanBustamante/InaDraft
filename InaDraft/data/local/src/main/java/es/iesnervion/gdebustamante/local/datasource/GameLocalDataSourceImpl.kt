package es.iesnervion.gdebustamante.local.datasource

import es.gdebustamante.inadraft.domain.GameBO
import es.gdebustamante.inadraft.formation.FormationLocalDataSource
import es.gdebustamante.inadraft.game.GameLocalDataSource
import es.iesnervion.gdebustamante.local.room.dao.GameDao
import es.iesnervion.gdebustamante.local.room.toDBO
import es.iesnervion.gdebustamante.local.room.toGameBO

/**
 * Implementación de [GameLocalDataSource] que usa una BBDD para operaciones CRUD sobre partidas
 */
class GameLocalDataSourceImpl(private val gameDao: GameDao) : GameLocalDataSource {

    override suspend fun getLocalBestGames(): List<GameBO> =
        gameDao.getBestGames().map { it.toGameBO() }

    override suspend fun insertLocalGames(games: List<GameBO>) {
        gameDao.insertGames(games.map { it.toDBO() })
    }

    override suspend fun insertLocalGame(gameBO: GameBO): Boolean =
        gameDao.insertGame(gameBO.toDBO()) == gameDao.getLastGameId().toLong()

}