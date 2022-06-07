package es.gdebustamante.inadraft.remote.datasource

import es.gdebustamante.inadraft.position.PositionRemoteDataSource
import es.gdebustamante.inadraft.domain.PositionBO
import es.gdebustamante.inadraft.entity.toBO
import es.gdebustamante.inadraft.remote.api.InaDraftApiService

class PositionRemoteDataSourceImpl(private val apiService: InaDraftApiService) : PositionRemoteDataSource {

    override suspend fun getRemotePositions(): List<PositionBO> {
        val positionResponse = apiService.getPositions()
        return if (positionResponse.isSuccessful) positionResponse.body()?.map { it.toBO() } ?: emptyList() else emptyList()
    }
}