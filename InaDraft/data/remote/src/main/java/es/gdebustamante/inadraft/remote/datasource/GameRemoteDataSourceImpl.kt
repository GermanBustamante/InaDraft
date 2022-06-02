package es.gdebustamante.inadraft.remote.datasource

import es.gdebustamante.inadraft.domain.GameBO
import es.gdebustamante.inadraft.entity.toBO
import es.gdebustamante.inadraft.game.GameRemoteDataSource
import es.gdebustamante.inadraft.remote.api.APIService

class GameRemoteDataSourceImpl(private val apiService: APIService) : GameRemoteDataSource {

    override suspend fun getRemoteGames(): List<GameBO> =
        apiService.getGames().map { it.toBO() }

}