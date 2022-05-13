package es.gdebustamante.inadraft.repository

import es.gdebustamante.inadraft.PositionRemoteDataSource

class PositionRepository(private val positionRemoteDataSource: PositionRemoteDataSource) {

    suspend fun getPositionList() = positionRemoteDataSource.getPositions()

}