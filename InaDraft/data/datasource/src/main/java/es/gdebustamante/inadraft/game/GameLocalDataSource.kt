package es.gdebustamante.inadraft.game

import es.gdebustamante.inadraft.domain.GameBO

/**
 * Interfaz donde estarán los métodos para operaciones CRUD en Local sobre Partidas
 */
interface GameLocalDataSource {

    /**
     * Recoge un listado de partidas de local
     */
    suspend fun getLocalBestGames(): List<GameBO>

    /**
     * Guarda un listado de partidas en Local
     */
    suspend fun insertLocalGames(games : List<GameBO>)

    /**
     * Guarda una partida en Local
     */
    suspend fun insertLocalGame(gameBO: GameBO) : Boolean
}