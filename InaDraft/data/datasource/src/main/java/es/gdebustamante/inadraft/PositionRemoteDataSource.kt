package es.gdebustamante.inadraft

import es.gdebustamante.inadraft.domain.PositionBO

interface PositionRemoteDataSource {
    suspend fun getPositions(): List<PositionBO>
}