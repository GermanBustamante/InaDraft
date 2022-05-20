package es.gdebustamante.inadraft.repository

import es.gdebustamante.inadraft.domain.PositionBO
import es.gdebustamante.inadraft.position.PositionLocalDataSource
import es.gdebustamante.inadraft.position.PositionRemoteDataSource

class PositionRepository(private val positionRemoteDataSource: PositionRemoteDataSource, private val positionLocalDataSource: PositionLocalDataSource) {

    suspend fun getPositions(): List<PositionBO> {
        var positons = positionLocalDataSource.getLocalPositions()
        if (positons.isEmpty()){
            positons = positionRemoteDataSource.getRemotePositions()
            positionLocalDataSource.insertPositions(positons)
        }
        return positons
    }

}