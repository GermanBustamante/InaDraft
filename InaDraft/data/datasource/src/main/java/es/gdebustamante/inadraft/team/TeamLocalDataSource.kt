package es.gdebustamante.inadraft.team

import es.gdebustamante.inadraft.domain.TeamBO

/**
 * Interfaz donde estarán los métodos para operaciones CRUD en Local sobre Equipos
 */
interface TeamLocalDataSource {

    /**
     * Guarda un listado de equipos en Local
     */
    suspend fun getLocalTeams() : List<TeamBO>

    /**
     * Inserta un listado de equipos en local
     */
    suspend fun insertLocalTeams(teams: List<TeamBO>)
}