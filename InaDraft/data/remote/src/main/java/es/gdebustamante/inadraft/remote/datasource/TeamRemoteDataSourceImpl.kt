package es.gdebustamante.inadraft.remote.datasource

import es.gdebustamante.inadraft.team.TeamRemoteDataSource
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.remote.api.APIService
import es.gdebustamante.inadraft.entity.toBO

class TeamRemoteDataSourceImpl(private val apiService: APIService): TeamRemoteDataSource {

    private val teamNotSuccessful = TeamBO(-1, "null", "null")

    override suspend fun getRemoteTeams(): List<TeamBO> {
        val teamsResponse = apiService.getTeams()
        return if (teamsResponse.isSuccessful) teamsResponse.body()?.map { it.toBO() } ?: emptyList() else emptyList()
    }

    override suspend fun getRemoteTeam(teamId: Int): TeamBO {
        val teamResponse = apiService.getTeam(teamId)
        return if (teamResponse.isSuccessful) teamResponse.body()?.toBO() ?: teamNotSuccessful  else teamNotSuccessful
    }

}