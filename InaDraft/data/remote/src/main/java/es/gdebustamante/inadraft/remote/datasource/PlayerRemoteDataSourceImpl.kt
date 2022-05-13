package es.gdebustamante.inadraft.remote.datasource

import es.gdebustamante.inadraft.PlayerRemoteDataSource
import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.remote.api.APIService
import es.gdebustamante.inadraft.entity.toBO

class PlayerRemoteDataSourceImpl(private val apiService: APIService) : PlayerRemoteDataSource {

    override suspend fun getPlayerListFromTeam(teamId: Int): List<PlayerBO> {
        val playersResponse = apiService.getPlayers()
        return if (playersResponse.isSuccessful) playersResponse.body()?.map { it.toBO() } ?: emptyList() else emptyList()
    }

}