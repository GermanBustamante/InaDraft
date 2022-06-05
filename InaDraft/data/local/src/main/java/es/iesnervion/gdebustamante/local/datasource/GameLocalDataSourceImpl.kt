package es.iesnervion.gdebustamante.local.datasource

import es.gdebustamante.inadraft.domain.GameBO
import es.gdebustamante.inadraft.game.GameLocalDataSource
import es.iesnervion.gdebustamante.local.room.dao.GameDao
import es.iesnervion.gdebustamante.local.room.toBO
import es.iesnervion.gdebustamante.local.room.toDBO
import es.iesnervion.gdebustamante.local.room.toGameBO

class GameLocalDataSourceImpl(private val gameDao: GameDao) : GameLocalDataSource {

    override suspend fun getLocalBestGames(): List<GameBO> =
        gameDao.getBestGames().map { it.toGameBO() }

    override suspend fun insertLocalGames(games: List<GameBO>) {
        gameDao.insertGames(games.map { it.toDBO() })
    }

    override suspend fun insertLocalGame(gameBO: GameBO): Boolean{
        gameDao.insertGame(gameBO.toDBO())
        //TODO ARREGLAR GAMERELATION DEBE SER NULL
        return true
    }

    override suspend fun getLastGameInserted(): GameBO = TODO()
//       TODO() gameDao.getLastGame().toGameBO()
}