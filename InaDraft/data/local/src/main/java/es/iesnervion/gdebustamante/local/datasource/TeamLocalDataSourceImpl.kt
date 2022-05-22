package es.iesnervion.gdebustamante.local.datasource

import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.team.TeamLocalDataSource
import es.iesnervion.gdebustamante.local.room.dao.TeamDao

class TeamLocalDataSourceImpl(
    private val teamDao : TeamDao
): TeamLocalDataSource {
    override suspend fun getLocalTeams(): List<TeamBO> {
        return emptyList()
    }

    override suspend fun getLocalTeam(teamId: Int): TeamBO {
        return TeamBO(1, ",", "")
    }

    override suspend fun insertLocalTeams(remoteTeams: List<TeamBO>) {

    }
}