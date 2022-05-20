package es.gdebustamante.inadraft.remote.datasource

import es.gdebustamante.inadraft.player.PlayerRemoteDataSource
import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.remote.api.APIService
import es.gdebustamante.inadraft.entity.toBO

class PlayerRemoteDataSourceImpl(private val apiService: APIService) : PlayerRemoteDataSource {
    override suspend fun getRemotePlayers(): List<PlayerBO> {
        return emptyList()
    }

    override suspend fun getRemotePlayersFromTeam(teamId: Int): List<PlayerBO> {
        val playersResponse = apiService.getPlayersFromTeam(teamId)
        return if (playersResponse.isSuccessful) playersResponse.body()?.map { it.toBO() } ?: emptyList() else emptyList()
    }

}