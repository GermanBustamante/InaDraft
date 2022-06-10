package es.gdebustamante.inadraft.player

import es.gdebustamante.inadraft.domain.PlayerBO

/**
 * Interfaz donde estarán los métodos para operaciones CRUD en Local sobre Jugadores
 */
interface PlayerLocalDataSource {

    /**
     * Recoge un listado de jugadores de Local
     */
    suspend fun getLocalPlayers(): List<PlayerBO>

    /**
     * Recoge un listado de jugadores de Local de un equipo específico
     */
    suspend fun getLocalPlayersFromTeam(teamId : Int): List<PlayerBO>

    /**
     * Guarda un listado de jugadores en Local
     */
    suspend fun insertPlayers(players: List<PlayerBO>)

    /**
     * Recoge un listado de jugadores de Local dado una posición
     */
    suspend fun getRandomPlayersByPosition(positionId: Int): List<PlayerBO>

    /**
     * Recoge un jugador de Local
     */
    suspend fun getLocalPlayer(playerId: Int): PlayerBO

}