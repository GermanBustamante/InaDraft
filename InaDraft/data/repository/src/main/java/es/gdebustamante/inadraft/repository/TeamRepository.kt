package es.gdebustamante.inadraft.repository

import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.TeamRemoteDataSource

class TeamRepository(private val teamRemoteDataSource : TeamRemoteDataSource) {
    suspend fun getTeamList(): List<TeamBO> = teamRemoteDataSource.getTeams()
}