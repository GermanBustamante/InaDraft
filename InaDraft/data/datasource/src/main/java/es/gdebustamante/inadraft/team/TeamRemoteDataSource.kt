package es.gdebustamante.inadraft.team

import es.gdebustamante.inadraft.domain.TeamBO

interface TeamRemoteDataSource {
    suspend fun getRemoteTeams() : List<TeamBO>

    suspend fun getRemoteTeam(teamId: Int): TeamBO
}