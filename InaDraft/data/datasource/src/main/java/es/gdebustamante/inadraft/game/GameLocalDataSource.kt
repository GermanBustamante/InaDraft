package es.gdebustamante.inadraft.game

import es.gdebustamante.inadraft.domain.GameBO

interface GameLocalDataSource {

    suspend fun getLocalBestGames(): List<GameBO>

    suspend fun insertLocalGames(games : List<GameBO>)

    suspend fun insertLocalGame(gameBO: GameBO) : Boolean
}