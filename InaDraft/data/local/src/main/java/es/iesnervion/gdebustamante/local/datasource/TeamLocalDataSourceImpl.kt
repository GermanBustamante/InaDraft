package es.iesnervion.gdebustamante.local.datasource

import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.team.TeamLocalDataSource

class TeamLocalDataSourceImpl: TeamLocalDataSource {
    override suspend fun getLocalTeams(): List<TeamBO> {
        return emptyList()
    }

    override suspend fun getLocalTeam(teamId: Int): TeamBO {
        return TeamBO(1, ",", "")
    }

    override suspend fun insertLocalTeams(remoteTeams: List<TeamBO>) {

    }
}