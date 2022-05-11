package es.gdebustamante.inadraft.remote.datasource

import es.gdebustamante.inadraft.TeamRemoteDataSource
import es.gdebustamante.inadraft.domain.TeamBO
import es.gdebustamante.inadraft.remote.api.APIService
import es.sdos.formacion.monumentosandaluces.entity.toBO

class TeamRemoteDataSourceImpl(private val apiService: APIService): TeamRemoteDataSource {

    override suspend fun getTeams(): List<TeamBO> {
        val teamsResponse = apiService.getTeams()
        return if (teamsResponse.isSuccessful) teamsResponse.body()?.map { it.toBO() } ?: emptyList() else emptyList()
    }

}