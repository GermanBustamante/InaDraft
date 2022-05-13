package es.gdebustamante.inadraft

import es.gdebustamante.inadraft.domain.TeamBO

interface TeamRemoteDataSource {
    suspend fun getTeams() : List<TeamBO>

    suspend fun getTeam(teamId: Int): TeamBO
}