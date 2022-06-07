package es.gdebustamante.inadraft.position

import es.gdebustamante.inadraft.domain.PositionBO

interface PositionLocalDataSource {

    suspend fun getLocalPositions(): List<PositionBO>

    suspend fun insertPositions(positons: List<PositionBO>)
}