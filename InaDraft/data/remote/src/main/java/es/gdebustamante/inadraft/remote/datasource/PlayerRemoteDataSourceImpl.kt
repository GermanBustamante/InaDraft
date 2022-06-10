package es.gdebustamante.inadraft.remote.datasource

import es.gdebustamante.inadraft.player.PlayerRemoteDataSource
import es.gdebustamante.inadraft.domain.PlayerBO
import es.gdebustamante.inadraft.remote.api.InaDraftApiService
import es.gdebustamante.inadraft.entity.toBO
import es.gdebustamante.inadraft.game.GameRemoteDataSource

/**
 * Implementación de [PlayerRemoteDataSource] que usa una BBDD para operaciones CRUD sobre formaciones
 */
class PlayerRemoteDataSourceImpl(private val apiService: InaDraftApiService) : PlayerRemoteDataSource {

    override suspend fun getRemotePlayers(): List<PlayerBO> {
        val playersResponse = apiService.getPlayers()
        return if (playersResponse.isSuccessful) playersResponse.body()?.map { it.toBO() } ?: emptyList() else emptyList()
    }

    override suspend fun getRemotePlayersFromTeam(teamId: Int): List<PlayerBO> {
        val playersResponse = apiService.getPlayersFromTeam(teamId)
        return if (playersResponse.isSuccessful) playersResponse.body()?.map { it.toBO() } ?: emptyList() else emptyList()
    }

}