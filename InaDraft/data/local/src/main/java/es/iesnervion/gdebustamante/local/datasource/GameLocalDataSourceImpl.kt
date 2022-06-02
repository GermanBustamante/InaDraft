package es.iesnervion.gdebustamante.local.datasource

import android.os.Build
import androidx.annotation.RequiresApi
import es.gdebustamante.inadraft.domain.GameBO
import es.gdebustamante.inadraft.game.GameLocalDataSource
import es.iesnervion.gdebustamante.local.room.dao.GameDao
import es.iesnervion.gdebustamante.local.room.toDBO
import es.iesnervion.gdebustamante.local.room.toGameBO

class GameLocalDataSourceImpl(private val gameDao: GameDao) : GameLocalDataSource {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getLocalGames(): List<GameBO> =
        gameDao.getGames().map { it.toGameBO() }

    override suspend fun insertLocalGames(games: List<GameBO>) {
        gameDao.insertGames(games.map { it.toDBO() })
    }
}