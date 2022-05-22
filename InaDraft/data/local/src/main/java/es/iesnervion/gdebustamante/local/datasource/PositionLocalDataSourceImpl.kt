package es.iesnervion.gdebustamante.local.datasource

import es.gdebustamante.inadraft.domain.PositionBO
import es.gdebustamante.inadraft.position.PositionLocalDataSource
import es.iesnervion.gdebustamante.local.room.dao.PlayerDao
import es.iesnervion.gdebustamante.local.room.dao.PositionDao

class PositionLocalDataSourceImpl(
    private val positionDao: PositionDao
): PositionLocalDataSource {
    override suspend fun getLocalPositions(): List<PositionBO> {
        return emptyList()
    }

    override suspend fun insertPositions(positons: List<PositionBO>) {

    }
}