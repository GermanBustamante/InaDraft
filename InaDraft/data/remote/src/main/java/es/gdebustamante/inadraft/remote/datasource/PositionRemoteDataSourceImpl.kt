package es.gdebustamante.inadraft.remote.datasource

import es.gdebustamante.inadraft.position.PositionRemoteDataSource
import es.gdebustamante.inadraft.domain.PositionBO
import es.gdebustamante.inadraft.entity.toBO
import es.gdebustamante.inadraft.game.GameRemoteDataSource
import es.gdebustamante.inadraft.remote.api.InaDraftApiService

/**
 * Implementación de [PositionRemoteDataSource] que usa una BBDD para operaciones CRUD sobre formaciones
 */
class PositionRemoteDataSourceImpl(private val apiService: InaDraftApiService) : PositionRemoteDataSource {

    override suspend fun getRemotePositions(): List<PositionBO> {
        val positionResponse = apiService.getPositions()
        return if (positionResponse.isSuccessful) positionResponse.body()?.map { it.toBO() } ?: emptyList() else emptyList()
    }
}