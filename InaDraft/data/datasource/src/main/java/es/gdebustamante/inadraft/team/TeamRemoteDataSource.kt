package es.gdebustamante.inadraft.team

import es.gdebustamante.inadraft.domain.TeamBO

/**
 * Interfaz donde estarán los métodos para operaciones CRUD en Remoto sobre Equipos
 */
interface TeamRemoteDataSource {

    /**
     * Recoge un listado de equipos de remoto y los devuelve
     */
    suspend fun getRemoteTeams() : List<TeamBO>

    /**
     * Recoge un equipo específico de remoto y lo devuelve
     */
    suspend fun getRemoteTeam(teamId: Int): TeamBO
}