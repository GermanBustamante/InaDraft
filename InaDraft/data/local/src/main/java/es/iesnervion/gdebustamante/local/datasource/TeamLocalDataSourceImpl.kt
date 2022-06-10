package es.iesnervion.gdebustamante.local.datasource

import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.formation.FormationLocalDataSource
import es.gdebustamante.inadraft.team.TeamLocalDataSource
import es.iesnervion.gdebustamante.local.room.dao.TeamDao
import es.iesnervion.gdebustamante.local.room.toBO
import es.iesnervion.gdebustamante.local.room.toDBO

/**
 * Implementación de [TeamLocalDataSource] que usa una BBDD para operaciones CRUD sobre equipos
 */
class TeamLocalDataSourceImpl(
    private val teamDao : TeamDao
): TeamLocalDataSource {

    override suspend fun getLocalTeams(): List<TeamBO> =
        teamDao.getTeams().map { it.toBO() }

    override suspend fun insertLocalTeams(teams: List<TeamBO>){
        teamDao.insertTeams(teams.map { it.toDBO() })
    }
}