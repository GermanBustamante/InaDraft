package es.gdebustamante.inadraft.player

import es.gdebustamante.inadraft.domain.PlayerBO

/**
 * Interfaz donde estarán los métodos para operaciones CRUD en Remoto sobre Jugadores
 */
interface PlayerRemoteDataSource {

    /**
     * Recoge un listado de jugadores de Remoto y las devuelve
     */
    suspend fun getRemotePlayers(): List<PlayerBO>

    /**
     * Recoge un listado de jugadores de un equipo específico en Remoto y las devuelve
     */
    suspend fun getRemotePlayersFromTeam(teamId : Int): List<PlayerBO>
}