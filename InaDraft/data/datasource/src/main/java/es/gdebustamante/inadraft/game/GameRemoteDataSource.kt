package es.gdebustamante.inadraft.game

import es.gdebustamante.inadraft.domain.GameBO

interface GameRemoteDataSource {

    suspend fun getRemoteGames() : List<GameBO>

    suspend fun insertRemoteGame(game: GameBO): Boolean

}