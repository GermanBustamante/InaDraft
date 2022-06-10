package es.gdebustamante.inadraft.game

import es.gdebustamante.inadraft.domain.GameBO

/**
 * Interfaz donde estarán los métodos para operaciones CRUD en Remoto sobre Partidas
 */
interface GameRemoteDataSource {

    /**
     * Recoge un listado de partidas de Remoto y las devuelve
     */
    suspend fun getRemoteGames() : List<GameBO>

    /**
     * Guarda un listado de partidas en Remoto
     */
    suspend fun insertRemoteGame(game: GameBO): Boolean

}