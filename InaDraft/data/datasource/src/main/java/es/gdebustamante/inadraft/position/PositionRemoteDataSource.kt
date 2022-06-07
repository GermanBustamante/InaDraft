package es.gdebustamante.inadraft.position

import es.gdebustamante.inadraft.domain.PositionBO

interface PositionRemoteDataSource {

    suspend fun getRemotePositions(): List<PositionBO>
}