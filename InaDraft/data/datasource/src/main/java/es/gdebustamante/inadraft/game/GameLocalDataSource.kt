package es.gdebustamante.inadraft.game

import es.gdebustamante.inadraft.domain.GameBO

interface GameLocalDataSource {

    suspend fun getLocalGames(): List<GameBO>

    suspend fun insertLocalGames(games : List<GameBO>)

}